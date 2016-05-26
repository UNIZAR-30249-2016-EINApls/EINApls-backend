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
    public static MaquinaExpendedora getMaquina(int id){
        //Llamamos a repositorio maquinas  para que nos devuelva la maquina con id id
        MaquinaExpendedora maquinaExpendedora = RepositorioMaquinas.findMaquina(id);
        return maquinaExpendedora;

    }
    public static MaquinaExpendedora[] getMaquinas(TipoPiso tipoPiso, TipoEdificio tipoEdificio){
        //Llamamos a repositorio maquinas para que nos devuelva una lista con las maquinas en tipoEdificio y tipoPiso
        MaquinaExpendedora[] maquinas = RepositorioMaquinas.findMaquinas(tipoPiso,tipoEdificio);
        return maquinas;

    }
}
