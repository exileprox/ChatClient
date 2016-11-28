package g53sqm.chat.client;

import g53sqm.chat.client.servermessage.Message;

public interface ClientListener {
	public abstract void onServerMessageReceived(Message message);
}
