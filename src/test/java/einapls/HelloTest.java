package einapls;

import einapls.httpserver.Server;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.*;

public class HelloTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        Server.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target("http://localhost:8888/");
    }

    @After
    public void tearDown() throws Exception {
        Server.stopServer();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("hello").request().get(String.class);
        assertEquals("Hello world!", responseMsg);
    }
}
