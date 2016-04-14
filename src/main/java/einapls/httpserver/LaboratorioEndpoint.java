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
@Path("laboratorio/{id}")
public class LaboratorioEndpoint {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getLaboratorio(@PathParam("id") String id) {
        LOGGER.info("GET /laboratorio");
        return "this should be a json of labotatory with id = " + id;
    }
}
