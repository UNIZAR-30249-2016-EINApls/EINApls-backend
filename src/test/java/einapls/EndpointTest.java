package einapls;

import einapls.puertosYAdaptadores.Server;
import org.junit.*;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class EndpointTest {

    private static WebTarget target;
    private static final Gson gson = new Gson();


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
        String responseMsg = target.path("espacio/26").request().get(String.class);
        JsonParser parser = new JsonParser();
        try {
            parser.parse(responseMsg);
        }
        catch (JsonSyntaxException e) {
            Assert.fail();

        }
    }

    @Test
    public void testGetEspacios() {
        String responseMsg = target.path("espacios/PISO_0/ADA_BYRON").request().get(String.class);
        JsonParser parser = new JsonParser();
        try {
            parser.parse(responseMsg);
        }
        catch (JsonSyntaxException e) {
            Assert.fail();

        }
    }

    @Test
    public void testGetIncidencia() {
        String responseMsg = target.path("incidencia/1").request().get(String.class);
        JsonParser parser = new JsonParser();
        try {
            parser.parse(responseMsg);
        }
        catch (JsonSyntaxException e) {
            Assert.fail();

        }
    }

    @Test
    public void testGetIncidencias() {
        String responseMsg = target.path("incidencias/PISO_0/ADA_BYRON").request().get(String.class);
        JsonParser parser = new JsonParser();
        try {
            parser.parse(responseMsg);
        }
        catch (JsonSyntaxException e) {
            Assert.fail();

        }
    }

    @Test
    public void testGetMaquina() {
        String responseMsg = target.path("maquina/1").request().get(String.class);
        JsonParser parser = new JsonParser();
        try {
            parser.parse(responseMsg);
        }
        catch (JsonSyntaxException e) {
            Assert.fail();

        }
    }

    @Test
    public void testGetMaquinas() {
        String responseMsg = target.path("maquinas/PISO_0/ADA_BYRON").request().get(String.class);
        JsonParser parser = new JsonParser();
        try {
            parser.parse(responseMsg);
        }
        catch (JsonSyntaxException e) {
            Assert.fail();

        }
    }

    

}
