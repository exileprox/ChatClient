package g53sqm.chat.client;

import g53sqm.chat.client.servermessage.Message;

import java.io.IOException;

public class ClientRunner {

    static Client client;
    final static int PORT = 9000;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
