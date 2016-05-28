package einapls.puertosYAdaptadores;

import einapls.application.OperacionesIncidencias;
import einapls.domain.Incidencia;
import einapls.puertosYAdaptadores.deserializers.IncidenciaDeserializer;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;
import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/issues/")
public class IncidenciaEndpoint {

    private static final Logger LOGGER = Grizzly.logger(IncidenciaEndpoint.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getIncidencia(@PathParam("id") String id) {
        LOGGER.info("GET /incidencia");
        //Le pasamos el id de la incidencia al serializar para obtener un GeoJSon
        Incidencia[] incidencias = new Incidencia[1];
        incidencias[0] = OperacionesIncidencias.getIncidencia(Integer.parseInt(id));
        SerializerToGeoJson serializer = new SerializerToGeoJson(incidencias);
        String geoJsonIncidencias = serializer.DoSerializeToGeoJson();
        return geoJsonIncidencias;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postIncidencia(String geojson){
        LOGGER.info("POST /incidencia");
        Incidencia i = IncidenciaDeserializer.deserializeGeoJsonIncidencia(geojson);
        Incidencia i2 = OperacionesIncidencias.postIncidencias(i);

        Incidencia[] incidencias = new Incidencia[1];

        incidencias[0] = i2;

        SerializerToGeoJson serializer = new SerializerToGeoJson(incidencias);
        String geoJsonIncidencias = serializer.DoSerializeToGeoJson();
        return geoJsonIncidencias;
    }
}
