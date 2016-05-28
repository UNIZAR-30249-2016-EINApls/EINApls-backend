package einapls.puertosYAdaptadores;

import einapls.application.OperacionesMaquina;
import einapls.domain.MaquinaExpendedora;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;
import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("{tipoEdificio}/{tipoPiso}/machines")
public class MaquinasEndpoint {

    private static final Logger LOGGER = Grizzly.logger(MaquinasEndpoint.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIncidencias(@PathParam("tipoPiso") TipoPiso tipoPiso,
                              @PathParam("tipoEdificio") TipoEdificio tipoEdificio) {
        LOGGER.info("GET /maquinas");

        MaquinaExpendedora[] maquinas = OperacionesMaquina.getMaquinas(tipoPiso, tipoEdificio);
        //Le pasamos el array de Maquinas al serializar para obtener un GeoJSon
        SerializerToGeoJson serializer = new SerializerToGeoJson(maquinas);
        String geoJsonEspacios = serializer.DoSerializeToGeoJson();
        return geoJsonEspacios;


    }
}
