package g53sqm.chat.client.servercommand;

import g53sqm.chat.client.servercommand.*;

import java.net.Socket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CommandTest {
	
	@Test
	public void TestHailCommand()
	{
		Command cmd = new HailCommand("All hail the queen");
		assertEquals("HAIL",cmd.getCommandPrefix());
		assertEquals("HAIL All hail the queen",cmd.getFullCommand());
	}
	@Test
	public void TestIdentityCommand()
	{
		Command cmd = new IdentityCommand("Chris");
		assertEquals("IDEN",cmd.getCommandPrefix());
		assertEquals("IDEN Chris",cmd.getFullCommand());
	}
	@Test
	public void TestListCommand()
	{
		Command cmd = new ListCommand();
		assertEquals("LIST",cmd.getCommandPrefix());
		assertEquals("LIST",cmd.getFullCommand());
	}
	@Test
	public void TestMessageCommand()
	{
		Command cmd = new MessageCommand("Chris","Hello there bud");
		assertEquals("MESG",cmd.getCommandPrefix());
		assertEquals("MESG Chris Hello there bud",cmd.getFullCommand());
	}
	@Test
	public void TestQuitCommand()
	{
		Command cmd = new QuitCommand();
		assertEquals("QUIT",cmd.getCommandPrefix());
		assertEquals("QUIT",cmd.getFullCommand());
	}
	@Test
	public void TestStatusCommand()
	{
		Command cmd = new StatusCommand();
		assertEquals("STAT",cmd.getCommandPrefix());
		assertEquals("STAT",cmd.getFullCommand());
	}
	
}
