package einapls.application;

import einapls.domain.Espacio;
import einapls.domain.RepositorioEspacios;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

/**
 * Operaciones relacionadas con los Espacios
 */
public class OperacionesEspacios {

    public static Espacio getEspacio (int id){
        //Llamamos a repositorio espacios para que nos devuelva el espacio con id id
        Espacio espacio = RepositorioEspacios.findEspacio(id);
        return espacio;

    }

    public static Espacio[] getEspacios (TipoPiso tipoPiso, TipoEdificio tipoEdificio ){
        //Llamamos a repositorio espacios para que nos devuelva una lista con los espacios en tipoEdificio y tipoPiso
        Espacio[] espacios = RepositorioEspacios.findEspacios(tipoPiso, tipoEdificio);
        return espacios;
    }
}
