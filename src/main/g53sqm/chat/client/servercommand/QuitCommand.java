package g53sqm.chat.client.servercommand;

public final class QuitCommand implements Command {

	private static final String commandPrefix = "QUIT";
	
	@Override
	public String getCommandPrefix() {
		return commandPrefix;
	}
	@Override
	public String getFullCommand() {
		return getCommandPrefix();
	}

}
