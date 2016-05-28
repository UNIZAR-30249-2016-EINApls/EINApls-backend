package einapls.puertosYAdaptadores;

import einapls.application.OperacionesMaquina;
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
public class SimuladorServicioHorarios {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMaquina() {
        LOGGER.info("GET /horarios");
        String horariosJSON = "{ \"8:00\": \"Fisica\"," +
                "\"9:00\": \"Programacion\"," +
                "\"10:00\": \"Laboratorio de Software\"," +
                "\"11:00\": \"Ingenieria de Requisitos\"," +
                "\"12:00\": \"Arquitectura Software\"," +
                "\"13:00\": \"Videojuegos\"," +
                "\"14:00\": \"Sistemas de la Informacion\"," +
                "\"15:00\": \"Redes de Computadores\"," +
                "\"16:00\": \"Proyecto Software\"," +
                "\"17:00\": \"Ingenieria Web\"," +
                "\"18:00\": \"Sistemas y Tecnologias Web\"," +
                "\"19:00\": \"LIBRE\"," +
                "\"20:00\": \"Sistemas Distribuidos\"," +
                "\"21:00\": \"LIBRE\"}";




        return horariosJSON;
    }
}
