package einapls.application;

import einapls.domain.Incidencia;
import einapls.domain.RepositorioIncidencias;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

/**
 * Created by Jorge on 25/05/2016.
 */
public class OperacionesIncidencias {

    //Crea una incidencia, y una vez creada, la devuelve de nuevo cargandola desde la BD con su correspondiente id
    public static Incidencia postIncidencias(Incidencia incidencia){
        int id = RepositorioIncidencias.createIncidencia(incidencia);
        return getIncidencia(id);
    }

    //Devuelve una Incidencia de la BD identificada por el id id
    public static Incidencia getIncidencia(int id){
        //Llamamos a repositorio incidencias para que nos devuelva la incidencia con id id
        Incidencia incidencia = RepositorioIncidencias.findIncidencia(id);
        return incidencia;
    }

    //Devuelve un array de Incidencias con todas las incidencias de tipoPiso y tipoEdificio
    public static Incidencia[] getIncidencias(TipoPiso tipoPiso, TipoEdificio tipoEdificio){
        //Llamamos a repositorio incidencias para que nos devuelva una lista con las incidencias en tipoEdificio y tipoPiso
        Incidencia[] incidencias = RepositorioIncidencias.findIncidencias(tipoPiso, tipoEdificio);
        return incidencias;
    }
}
