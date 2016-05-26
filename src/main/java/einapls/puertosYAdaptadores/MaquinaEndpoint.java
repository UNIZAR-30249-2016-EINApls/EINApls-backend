package einapls.puertosYAdaptadores;

import einapls.application.OperacionesEspacios;
import einapls.application.OperacionesMaquina;
import einapls.domain.Espacio;
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


@Path("maquina/{id}")
public class MaquinaEndpoint {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMaquina(@PathParam("id") String id) {
        LOGGER.info("GET /maquina");

        //Le pasamos el id de la maquina al serializar para obtener un GeoJSon
        MaquinaExpendedora[] maquinas =  new MaquinaExpendedora[1];
        maquinas[0] = OperacionesMaquina.getMaquina(Integer.parseInt(id));
        SerializerToGeoJson serializer = new SerializerToGeoJson(maquinas);
        String geoJsonEspacios = serializer.serializeToGeoJson();
        return geoJsonEspacios;

    }
}
