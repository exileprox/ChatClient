package g53sqm.chat.client.servermessage;

import g53sqm.chat.client.servercommand.*;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageInterpreterTest {

	@Test
	public void TestMessageResultCodeIsBadWhenMessageStartsWithBad() {
		String message = "BAD User already registered";
		Message m = new MessageInterpreter().interpretServerMessage(message);
		assertEquals(ResultCode.BAD,m.code);
		assertEquals("User already registered",m.message);
	}
	
	@Test
	public void TestMessageResultCodeIsOkWhenMessageStartsWithOk() {
		String message = "OK Welcome to the chat server";
		Message m = new MessageInterpreter().interpretServerMessage(message);
		assertEquals(ResultCode.OK,m.code);
		assertEquals("Welcome to the chat server",m.message);
	}
	
	@Test
	public void TestMessageResultCodeIsUnknownWhenMessageNotStartsWithOkOrBad() {
		String message = "BLASHD I AM A GLITCH";
		Message m = new MessageInterpreter().interpretServerMessage(message);
		assertEquals(ResultCode.UNKNOWN,m.code);
		assertEquals(message,m.message);
	}

}
