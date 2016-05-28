package einapls.puertosYAdaptadores;

import einapls.application.OperacionesIncidencias;
import einapls.domain.Incidencia;
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


@Path("{tipoEdificio}/{tipoPiso}/issues")
public class IncidenciasEndpoint {

    private static final Logger LOGGER = Grizzly.logger(IncidenciasEndpoint.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIncidencias(@PathParam("tipoPiso") TipoPiso tipoPiso,
                              @PathParam("tipoEdificio") TipoEdificio tipoEdificio) {
        LOGGER.info("GET /incidencias");

        Incidencia[] incidencias = OperacionesIncidencias.getIncidencias(tipoPiso, tipoEdificio);
        //Le pasamos el array de Incidencias al serializar para obtener un GeoJSon
        SerializerToGeoJson serializer = new SerializerToGeoJson(incidencias);
        String geoJsonEspacios = serializer.DoSerializeToGeoJson();
        return geoJsonEspacios;


    }
}
