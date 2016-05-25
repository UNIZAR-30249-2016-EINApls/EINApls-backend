package einapls.application;

import einapls.domain.Espacio;

/**
 * Created by Jorge on 25/05/2016.
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
