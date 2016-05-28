package einapls;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import einapls.puertosYAdaptadores.Server;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

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
        String responseMsg = target.path("places/26").request().get(String.class);
        JsonParser parser = new JsonParser();
        try {
            parser.parse(responseMsg);
        }
        catch (JsonSyntaxException e) {
            Assert.fail();

        }
    }

    @Test
    public void testGetEspacioNotExist() {
        String responseMsg = target.path("places/1").request().get(String.class);
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
        String responseMsg = target.path("ADA_BYRON/PISO_0/places").request().get(String.class);
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
        String responseMsg = target.path("issues/1").request().get(String.class);
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
        String responseMsg = target.path("ADA_BYRON/PISO_0/issues").request().get(String.class);
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
        String responseMsg = target.path("machines/2").request().get(String.class);
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
        String responseMsg = target.path("ADA_BYRON/PISO_0/machines").request().get(String.class);
        JsonParser parser = new JsonParser();
        try {
            parser.parse(responseMsg);
        }
        catch (JsonSyntaxException e) {
            Assert.fail();
        }
    }

    

}
