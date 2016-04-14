package einapls.httpserver;

import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("hello")
public class HelloEndpoint {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        LOGGER.info("GET /hello");
        return "Hello world!";
    }


}
