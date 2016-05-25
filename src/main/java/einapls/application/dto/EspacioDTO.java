package einapls.application.dto;

import einapls.domain.Espacio;

/**
 * Data Transfer object de Espacios
 */
public class EspacioDTO {

    private Espacio[] espacios;

    EspacioDTO(Espacio[] espacios){
        this.espacios=espacios;
    }

    public String serializeToGeoJson(){
        //TODO Programar el get GEOJson de planta DTO
        return null;
    }
}
