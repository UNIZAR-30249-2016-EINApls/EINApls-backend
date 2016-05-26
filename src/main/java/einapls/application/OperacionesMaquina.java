package einapls.application;

import einapls.domain.Espacio;
import einapls.domain.MaquinaExpendedora;
import einapls.domain.RepositorioEspacios;
import einapls.domain.RepositorioMaquinas;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;

/**
 * Operaciones relacionadas con los Maquinas
 */
public class OperacionesMaquina {
    //TODO comrpobar que funciona
    public static String getMaquina(int id){
        //Llamamos a repositorio maquinas  para que nos devuelva la maquina con id id
        MaquinaExpendedora maquinaExpendedora = RepositorioMaquinas.findMaquina(id);
        //Le pasamos el id de la maquina al serializar para obtener un GeoJSon
        MaquinaExpendedora[] maquinas =  new MaquinaExpendedora[1];
        maquinas[0] = maquinaExpendedora;
        SerializerToGeoJson serializer = new SerializerToGeoJson(maquinas);
        String geoJsonEspacios = serializer.serializeToGeoJson();
        return geoJsonEspacios;

    }
    public static String getMaquinas(TipoPiso tipoPiso, TipoEdificio tipoEdificio){
        //Llamamos a repositorio maquinas para que nos devuelva una lista con las maquinas en tipoEdificio y tipoPiso
        MaquinaExpendedora[] maquinas = RepositorioMaquinas.findMaquinas(tipoPiso,tipoEdificio);
        //Le pasamos el array de Maquinas al serializar para obtener un GeoJSon
        SerializerToGeoJson serializer = new SerializerToGeoJson(maquinas);
        String geoJsonEspacios = serializer.serializeToGeoJson();
        return geoJsonEspacios;

    }
}
