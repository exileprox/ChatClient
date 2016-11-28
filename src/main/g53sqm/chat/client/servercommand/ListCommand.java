package g53sqm.chat.client.servercommand;

public final class ListCommand implements Command {

	private static final String commandPrefix = "LIST";

	@Override
	public String getCommandPrefix() {
		return commandPrefix;
	}

	@Override
	public String getFullCommand() {
		return getCommandPrefix();
	}

}
