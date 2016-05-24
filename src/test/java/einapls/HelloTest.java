package einapls;

import einapls.infrastructure.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class HelloTest {

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

    /*@Test
    public void testCafeteria() {
        String responseMsg = target.path("cafeteria").request().get(String.class);
        String responseSpected = "{\n" +
                "\"type\": \"FeatureCollection\",\n" +
                "\"crs\": { \"type\": \"name\", \"properties\": { \"name\": \"urn:ogc:def:crs:EPSG::3857\" } },\n" +
                "                                                                                \n" +
                "\"features\": [\n" +
                "{ \"type\": \"Feature\", \"properties\": { \"Layer\": \"02.540\", \"SubClasses\": \"AcDbEntity:AcDbHatch\", \"ExtendedEn\": null, \"Linetype\": null, \"EntityHand\": \"18031\", \"Text\": \"_SOLID\" }, \"geometry\": { \"type\": \"Polygon\", \"coordinates\": [ [ [ -0.888542049512971, 41.964544916921454 ], [ -0.888626111314884, 41.964544902759236 ], [ -0.88862570060792, 41.964501208074452 ], [ -0.888622174192953, 41.964501209490678 ], [ -0.888621814470302, 41.96446298000501 ], [ -0.88870176070519, 41.964462967259017 ], [ -0.888704043669417, 41.964706006462698 ], [ -0.888543562047583, 41.964706031954691 ], [ -0.888542049512971, 41.964544916921454 ] ], [ [ -0.888689425333961, 41.964702348362323 ], [ -0.888688298014156, 41.964702348362323 ], [ -0.888688289516771, 41.9647014745536 ], [ -0.888687159364504, 41.9647014745536 ], [ -0.88868716786189, 41.964702348362323 ], [ -0.888686040542085, 41.964702348362323 ], [ -0.888686057536856, 41.964704097395995 ], [ -0.888689442328732, 41.964704097395995 ], [ -0.888689425333961, 41.964702348362323 ] ], [ [ -0.888695070430369, 41.964702346946105 ], [ -0.888693940278103, 41.964702348362323 ], [ -0.888693931780717, 41.9647014745536 ], [ -0.888692804460913, 41.9647014745536 ], [ -0.888692812958298, 41.964702348362323 ], [ -0.888691682806032, 41.964702348362323 ], [ -0.888691699800803, 41.964704097395995 ], [ -0.888695084592678, 41.964704095979776 ], [ -0.888695070430369, 41.964702346946105 ] ], [ [ -0.88869284694784, 41.964465653831375 ], [ -0.888691716795574, 41.964465653831375 ], [ -0.88869171113065, 41.964464780022652 ], [ -0.888690580978384, 41.964464780022652 ], [ -0.888690589475769, 41.964465653831375 ], [ -0.888689459323503, 41.964465653831375 ], [ -0.888689476318274, 41.964467401448822 ], [ -0.888692863942611, 41.964467401448822 ], [ -0.88869284694784, 41.964465653831375 ] ], [ [ -0.888687204683893, 41.964465655247594 ], [ -0.888686074531627, 41.964465655247594 ], [ -0.888686066034241, 41.964464781438878 ], [ -0.888684938714437, 41.964464781438878 ], [ -0.888684947211822, 41.964465655247594 ], [ -0.888683817059556, 41.964465655247594 ], [ -0.888683834054327, 41.96446740286504 ], [ -0.888687218846202, 41.964467401448822 ], [ -0.888687204683893, 41.964465655247594 ] ] ] } }\n" +
                "]\n" +
                "}\n";

        assertEquals(responseSpected, responseMsg);
    }*/
}
