package einapls.puertosYAdaptadores;

import einapls.application.OperacionesEspacios;
import einapls.domain.Espacio;
import einapls.domain.enumerations.ConversorEnum;
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

@Path("espacios/{tipoPiso}/{tipoEdificio}")
public class EspaciosEndpoint {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEspacios(@PathParam("tipoPiso") String tipoPiso,
                              @PathParam("tipoEdificio") String tipoEdificio) {
        LOGGER.info("GET /espacios");
        TipoPiso tipoPis = ConversorEnum.getTipoPiso(tipoPiso);
        TipoEdificio tipoEdif = ConversorEnum.getTipoEdificio(tipoEdificio);

        Espacio[] espacios = OperacionesEspacios.getEspacios(tipoPis, tipoEdif);
        //Le pasamos el array de Espacios al serializar para obtener un GeoJSon
        SerializerToGeoJson serializer = new SerializerToGeoJson(espacios);
        String geoJsonEspacios = serializer.DoSerializeToGeoJson();
        return geoJsonEspacios;

    }
}
