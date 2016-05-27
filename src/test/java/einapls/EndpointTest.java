package einapls;

import einapls.puertosYAdaptadores.Server;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class EndpointTest {

    private static WebTarget target;

    @BeforeClass
    public static void setUp() throws Exception {
        Server.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target("http://localhost:8888");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Server.stopServer();

    }

    @Test
    public void testGetEspacio() {
        String responseMsg = target.path("espacio/27").request().get(String.class);
        String response = "{\"type\" : \"FeatureCollection\",\"features\":";
        assertEquals(true, responseMsg.startsWith(response));
    }

    @Test
    public void testGetEspacios() {
        String responseMsg = target.path("espacios/PISO_0/ADA_BYRON").request().get(String.class);
        String response = "{\"type\" : \"FeatureCollection\",\"features\":";
        assertEquals(true, responseMsg.startsWith(response));
    }

    

}
