package einapls.httpserver;

import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Marcos on 14/04/2016.
 */
@Path("salaestudio/{floor}")
public class SalaEstudioEndpint {
    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSalaEstudio(@PathParam("floor") String floor) {
        LOGGER.info("GET /salaestudio");
        return "this should be a json of salaestudio in floor = " + floor;
    }
}
