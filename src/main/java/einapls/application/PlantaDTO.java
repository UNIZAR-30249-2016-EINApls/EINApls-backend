package einapls.application;

import einapls.domain.Espacio;
import einapls.domain.Incidencia;
import einapls.domain.MaquinaExpendedora;

/**
 * Created by Jorge on 25/05/2016.
 */
public class PlantaDTO {

    private Espacio[] espacios;
    private MaquinaExpendedora[] maquinas;
    private Incidencia[] incidencias;

    PlantaDTO(Espacio[] espacios, MaquinaExpendedora[] maquinas, Incidencia[] incidencias){
        this.espacios=espacios;
        this.maquinas = maquinas;
        this.incidencias = incidencias;
    }

    public String  serializeToGeoJson(){
        //TODO Programar el get GEOJson de planta DTO
        return null;
    }
}
