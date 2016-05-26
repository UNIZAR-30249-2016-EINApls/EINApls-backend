package einapls.application;

import einapls.domain.Espacio;
import einapls.domain.RepositorioEspacios;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;

/**
 * Operaciones relacionadas con los Espacios
 */
public class OperacionesEspacios {

    public static String getEspacio (int id){
        //Llamamos a repositorio espacios para que nos devuelva el espacio con id id
        Espacio espacio = RepositorioEspacios.findEspacio(id);
        //Le pasamos el id del espacio al serializar para obtener un GeoJSon
        Espacio[] espacios = new Espacio[1];
        espacios[0] = espacio;
        SerializerToGeoJson serializer = new SerializerToGeoJson(espacios);
        String geoJsonEspacios = serializer.serializeToGeoJson();
        return geoJsonEspacios;
    }

    public static String getEspacios (TipoPiso tipoPiso, TipoEdificio tipoEdificio ){
        //Llamamos a repositorio espacios para que nos devuelva una lista con los espacios en tipoEdificio y tipoPiso
        Espacio[] espacios = RepositorioEspacios.findEspacios(tipoPiso, tipoEdificio);
        //Le pasamos el array de Espacios al serializar para obtener un GeoJSon
        SerializerToGeoJson serializer = new SerializerToGeoJson(espacios);
        String geoJsonEspacios = serializer.serializeToGeoJson();
        return geoJsonEspacios;
    }
}
