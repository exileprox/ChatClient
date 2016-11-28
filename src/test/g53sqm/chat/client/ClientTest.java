package g53sqm.chat.client;

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
public class ClientTest {

	@Test
	public void TestClientCanBeCreated() {
		Client client = new Client("localhost", 9090);
		assertNotNull(client);
	}

	@Test(expected = UnknownHostException.class)
	public void TestClientSocketClientCannotBeInitializedWhenHostIsWrong()
			throws UnknownHostException, IOException {
		Client client = new Client("BAD_HOSTNAM3", 9091);
		assertNotNull(client);
		client.initializeSocketClient();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestClientSocketClientCannotBeInitializedWhenPortIsNegative()
			throws UnknownHostException, IOException {
		Client client = new Client("localhost", -1);
		assertNotNull(client);
		client.initializeSocketClient();
	}
	
	@Test(expected = IOException.class)
	public void TestClientSocketClientCannotBeInitializedWhenPortIsWrong()
			throws UnknownHostException, IOException {
		Client client = new Client("localhost", 999);
		assertNotNull(client);
		client.initializeSocketClient();
	}

}
