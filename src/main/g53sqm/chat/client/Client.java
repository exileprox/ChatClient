package g53sqm.chat.client;

import g53sqm.chat.client.servercommand.*;
import g53sqm.chat.client.servermessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Client {

	private Socket socket;
	private MessageInterpreter interpreter;
	private String host;
	private int port;

	private volatile boolean running;
	private BufferedReader in;
	private PrintWriter out;

	private List<ClientListener> listeners;

	public Client(int port) {
		this("127.0.0.1", port);
	}

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
		listeners = new CopyOnWriteArrayList<ClientListener>();
		interpreter = new MessageInterpreter();
	}

	public void initializeSocketClient() throws UnknownHostException,
			IOException {
		try {
			socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

	public void run() {

		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("in or out failed");
			System.exit(-1);
		}
		running = true;
		Thread inThread = new Thread(new Runnable() {
			String line;

			public void run() {
				while (running) {
					try {
						line = in.readLine();
						System.out.println("Received from server:" + line);
						Message m = interpreter.interpretServerMessage(line);
						listeners.forEach(t->t.onServerMessageReceived(m));
					} catch (IOException e) {
						System.out.println("Read failed");
						System.exit(-1);
					}
				}
			}
		});
		inThread.start();

	}
	
	public void addListener(ClientListener listener)
	{
		listeners.add(listener);
	}

	public void sendCommandToServer(Command command) {
		sendOverConnection(command.getFullCommand());
	}

	private synchronized void sendOverConnection(String message) {
		out.println(message);
	}

}
