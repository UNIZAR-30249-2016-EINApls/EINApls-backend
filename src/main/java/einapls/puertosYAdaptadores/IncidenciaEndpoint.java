package einapls.puertosYAdaptadores;

import einapls.application.OperacionesIncidencias;
import einapls.domain.Incidencia;
import einapls.domain.Localizacion;
import einapls.domain.enumerations.EstadoIncidencia;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;
import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/incidencia")
public class IncidenciaEndpoint {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
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
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public String postIncidencia(@FormParam("edificio") String edificio, @FormParam("piso") String piso,
                                 @FormParam("foto") String foto, @FormParam("titulo") String titulo,
                                 @FormParam("descripcion") String descripcion, @FormParam("lat") String lat,
                                 @FormParam("lon") String lon){
        LOGGER.info("POST /incidencia");
        //Crear objeto incidencia
        Localizacion l = new Localizacion(lat, lon, piso, edificio);
        Incidencia incidencia = new Incidencia(1, titulo, EstadoIncidencia.ABIERTA, foto, descripcion, l);
        try {
            OperacionesIncidencias.postIncidencias(incidencia);
            return "{'error': false}";
        } catch (SQLException e) {
            e.printStackTrace();
            return "{'error': true}";
        }

    }
}
