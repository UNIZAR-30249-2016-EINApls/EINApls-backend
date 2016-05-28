package einapls.puertosYAdaptadores;

import einapls.application.OperacionesMaquina;
import einapls.application.SimuladorHorario;
import einapls.domain.MaquinaExpendedora;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;
import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("horarios")
public class HorarioEndpoint {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHorario() {
        return SimuladorHorario.getHorario();
    }
}
