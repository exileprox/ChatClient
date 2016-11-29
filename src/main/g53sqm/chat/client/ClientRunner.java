package g53sqm.chat.client;

import g53sqm.chat.client.servermessage.Message;

import java.io.IOException;
import java.util.Scanner;

public class ClientRunner {

    static Client client;
    final static int PORT = 9090;
    static boolean running = true;

    public static void main(String[] args) {
        try {
            client = new Client(PORT);
            client.initializeSocketClient();
            client.run();
            
            client.addListener(new ClientListener(){
				@Override
				public void onServerMessageReceived(Message message) {
					System.out.println("message result code is :" +message.getResultCode());
					System.out.println("message is :" +message.getMessage());
				}
            	
            });
            final Scanner scanner;
    		scanner = new Scanner(System.in);
    		Thread outThread = new Thread(new Runnable() {

    			String lineToSend;

    			public void run() {
    				while (running) {
    					try {
    						lineToSend = scanner.nextLine();
    						System.out.println("Sending to server:" + lineToSend);
    						client.sendOverConnection(lineToSend);
    					} catch (Exception e) {
    						e.printStackTrace();
    					}
    				}
    				scanner.close();
    			}
    		});
    		outThread.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
