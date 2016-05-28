package einapls.puertosYAdaptadores;

import einapls.application.OperacionesEspacios;
import einapls.domain.Espacio;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;
import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("places/{id}")
public class EspacioEndpoint {

    private static final Logger LOGGER = Grizzly.logger(EspacioEndpoint.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEspacio(@PathParam("id") String id) {
        LOGGER.info("GET /espacio");

        //Le pasamos el id del espacio al serializar para obtener un GeoJSon
        Espacio[] espacios = new Espacio[1];
        espacios[0] = OperacionesEspacios.getEspacio(Integer.parseInt(id));
        SerializerToGeoJson serializer = new SerializerToGeoJson(espacios);
        String geoJsonEspacios = serializer.doSerializeToGeoJson();
        return geoJsonEspacios;

    }
}
