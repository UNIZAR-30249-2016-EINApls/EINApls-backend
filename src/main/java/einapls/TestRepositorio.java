package einapls;

import einapls.application.OperacionesEspacios;
import einapls.domain.RepositorioEspacios;
import einapls.domain.RepositorioIncidencias;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

/**
 * Created by javmu on 25/05/2016.
 */
public class TestRepositorio {

    public static void main (String[] args) {
        System.out.println(RepositorioIncidencias.findIncidencia(3));
    }
}
