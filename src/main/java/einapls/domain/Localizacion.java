package einapls.domain;

import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

/**
 * Representará una Localizacion
 */
public class Localizacion {

    private final float coordX;         //Coordenada X de la localizacion
    private final float coordY;         //Coordenada Y de la localizacion
    private TipoPiso TIPOPISO;          //Tipo de piso de la localizacion, pudiendo ser SOTANO, PISO_0, PISO_1, PISO_2,
                                        //  PISO_3 y PISO_4
    private TipoEdificio TIPOEDIFICIO;  //Tipo de edificio de la localizacion, pudiendo ser ADA_BYRON, TORRES_QUEVEDO
                                        //  y BETANCOURT

    Localizacion (float coordX, float coordY, TipoPiso tipoPiso, TipoEdificio tipoEdificio) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.TIPOPISO = tipoPiso;
        this.TIPOEDIFICIO = tipoEdificio;

    }

    //GETTERs
    public float getCoordX() { return coordX; }

    public float getCoordY() { return coordY; }

    public TipoPiso getPiso() {
        return TIPOPISO;
    }

    public TipoEdificio getEdificio() { return TIPOEDIFICIO; }

}
