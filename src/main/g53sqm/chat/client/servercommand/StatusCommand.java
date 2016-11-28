package g53sqm.chat.client.servercommand;

public final class StatusCommand implements Command {

	private static final String commandPrefix = "STAT";
	
	@Override
	public String getCommandPrefix() {
		return commandPrefix;
	}
	@Override
	public String getFullCommand() {
		return getCommandPrefix();
	}

}
