package einapls.application.dto;

import einapls.domain.MaquinaExpendedora;

/**
 * Data Transfer object de Maquinas
 */
public class MaquinaDTO {

    private MaquinaExpendedora[] maquinas;

    public MaquinaDTO(MaquinaExpendedora[] maquinas){
        this.maquinas = maquinas;
    }

    public String serializeToGeoJson(){
        //TODO Programar el get GEOJson de maquinas dto
        return null;
    }
}
