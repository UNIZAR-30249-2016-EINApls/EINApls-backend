package einapls.application;

import einapls.domain.Espacio;
import einapls.domain.Incidencia;
import einapls.domain.RepositorioEspacios;
import einapls.domain.RepositorioIncidencias;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;

/**
 * Created by Jorge on 25/05/2016.
 */
public class OperacionesIncidencias {


    public boolean setIncidencias(String geoJsonIncidencia){
        //TODO hacerlo
        return false;
    }

    //TODO comprobar las dos ops de find
    public static String getIncidencia(int id){
        //Llamamos a repositorio incidencias para que nos devuelva la incidencia con id id
        Incidencia incidencia = RepositorioIncidencias.findIncidencia(id);
        //Le pasamos el id de la incidencia al serializar para obtener un GeoJSon
        Incidencia[] incidencias = new Incidencia[1];
        incidencias[0] = incidencia;
        SerializerToGeoJson serializer = new SerializerToGeoJson(incidencias);
        String geoJsonIncidencias = serializer.serializeToGeoJson();
        return geoJsonIncidencias;
    }

    public static String getIncidencias(TipoPiso tipoPiso, TipoEdificio tipoEdificio){
        //Llamamos a repositorio incidencias para que nos devuelva una lista con las incidencias en tipoEdificio y tipoPiso
        Incidencia[] incidencias = RepositorioIncidencias.findIncidencias(tipoPiso, tipoEdificio);
        //Le pasamos el array de Incidencias al serializar para obtener un GeoJSon
        SerializerToGeoJson serializer = new SerializerToGeoJson(incidencias);
        String geoJsonEspacios = serializer.serializeToGeoJson();
        return geoJsonEspacios;
    }
}
