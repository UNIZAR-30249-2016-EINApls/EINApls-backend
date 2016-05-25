package einapls.application.dto;

import einapls.domain.Espacio;
import einapls.domain.Incidencia;
import einapls.domain.MaquinaExpendedora;

/**
 * Data Transfer object de Plantas
 */
public class PlantaDTO {

    private Espacio[] espacios;
    private MaquinaExpendedora[] maquinas;
    private Incidencia[] incidencias;

    public PlantaDTO(Espacio[] espacios, MaquinaExpendedora[] maquinas, Incidencia[] incidencias){
        this.espacios=espacios;
        this.maquinas = maquinas;
        this.incidencias = incidencias;
    }

    public String  serializeToGeoJson(){
        //TODO Programar el get GEOJson de planta DTO
        return null;
    }
}
