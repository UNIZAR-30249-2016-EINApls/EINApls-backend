package einapls.domain;

import einapls.domain.enumerations.TipoEdificio;

/**
 * Clase que se comunicará con e respositorio donde se encuentran las incidencias
 */
public class RepositorioIncidencias {

    //// TODO: 25/05/2016 TODO la implementacion, actualmente todo falseado
    public boolean createIncidencia(Incidencia incidencia) {
        return false;
    }

    public Incidencia findIncidencia(int id) {
        return null;
    }

    public Incidencia[] findIncidencias(TipoEdificio tipoEdificio, int piso) {
        return null;
    }
}

