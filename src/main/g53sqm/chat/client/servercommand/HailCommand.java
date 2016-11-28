package g53sqm.chat.client.servercommand;

public final class HailCommand implements Command {

	private static final String commandPrefix = "HAIL";

	private String message;

	public HailCommand(String message) {
		this.message = message;
	}

	@Override
	public String getCommandPrefix() {
		return commandPrefix;
	}

	@Override
	public String getFullCommand() {
		return getCommandPrefix() + " " + message;
	}

}
