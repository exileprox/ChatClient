package g53sqm.chat.client.servercommand;

public final class IdentityCommand implements Command {

	private static final String commandPrefix = "IDEN";
	
	private String name;
	
	public IdentityCommand(String name){
		this.name=name;
	}

	@Override
	public String getCommandPrefix() {
		return commandPrefix;
	}

	@Override
	public String getFullCommand() {
		return getCommandPrefix()+" "+name;
	}

}
