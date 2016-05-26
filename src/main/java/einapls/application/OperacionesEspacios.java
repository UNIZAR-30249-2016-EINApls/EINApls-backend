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

    public String getEspacio (int id){
        //TODO getEspacio revisarlo
        //Llamamos a repositorio espacios para que nos devuelva una lista con los esacios en tipoEdificio y tipoPiso
        Espacio espacio = RepositorioEspacios.findEspacio(id);
        //Le pasamos el array de Espacios al serializar para obtener un GeoJSon
        Espacio[] espacios = new Espacio[1];
        espacios[1] = espacio;
        SerializerToGeoJson serializer = new SerializerToGeoJson(espacios);
        String geoJsonEspacios = serializer.serializeToGeoJson();
        return geoJsonEspacios;
    }

    public String getEspacios (TipoEdificio tipoEdificio, TipoPiso tipoPiso){
        //TODO getEspacios revisarlo
        //Llamamos a repositorio espacios para que nos devuelva una lista con los esacios en tipoEdificio y tipoPiso
        Espacio[] espacios = RepositorioEspacios.findEspacios(tipoEdificio, tipoPiso);
        //Le pasamos el array de Espacios al serializar para obtener un GeoJSon
        SerializerToGeoJson serializer = new SerializerToGeoJson(espacios);
        String geoJsonEspacios = serializer.serializeToGeoJson();
        return geoJsonEspacios;
    }
}
