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


    public void putIncidencias(String geoJsonIncidencia){
        //TODO hacerlo
    }

    //TODO comprobar las dos ops de find
    public static Incidencia getIncidencia(int id){
        //Llamamos a repositorio incidencias para que nos devuelva la incidencia con id id
        Incidencia incidencia = RepositorioIncidencias.findIncidencia(id);
        return incidencia;
    }

    public static Incidencia[] getIncidencias(TipoPiso tipoPiso, TipoEdificio tipoEdificio){
        //Llamamos a repositorio incidencias para que nos devuelva una lista con las incidencias en tipoEdificio y tipoPiso
        Incidencia[] incidencias = RepositorioIncidencias.findIncidencias(tipoPiso, tipoEdificio);
        return incidencias;
    }
}
