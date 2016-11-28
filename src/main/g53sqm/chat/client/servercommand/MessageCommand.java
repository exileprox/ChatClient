package g53sqm.chat.client.servercommand;

public final class MessageCommand implements Command {

	private static final String commandPrefix = "MESG";

	private String receiver;
	private String message;

	public MessageCommand(String receiver, String message) {
		this.receiver = receiver;
		this.message = message;
	}

	@Override
	public String getCommandPrefix() {
		return commandPrefix;
	}

	@Override
	public String getFullCommand() {
		return getCommandPrefix() + " " + receiver + " " + message;
	}

}
