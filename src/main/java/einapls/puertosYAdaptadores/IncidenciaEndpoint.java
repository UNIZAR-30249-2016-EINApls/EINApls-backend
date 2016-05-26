package einapls.puertosYAdaptadores;

import einapls.application.OperacionesEspacios;
import einapls.application.OperacionesIncidencias;
import einapls.domain.Espacio;
import einapls.domain.Incidencia;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;
import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("incidencia/{id}")
public class IncidenciaEndpoint {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIncidencia(@PathParam("id") String id) {
        LOGGER.info("GET /incidencia");

        //Le pasamos el id de la incidencia al serializar para obtener un GeoJSon
        Incidencia[] incidencias = new Incidencia[1];
        incidencias[0] = OperacionesIncidencias.getIncidencia(Integer.parseInt(id));
        SerializerToGeoJson serializer = new SerializerToGeoJson(incidencias);
        String geoJsonIncidencias = serializer.serializeToGeoJson();
        return geoJsonIncidencias;

    }
}
