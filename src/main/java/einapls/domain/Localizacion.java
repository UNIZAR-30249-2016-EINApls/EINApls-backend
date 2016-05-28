package einapls.domain;

import einapls.domain.enumerations.ConversorEnum;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

/**
 * Representará una Localizacion
 */
public class Localizacion {

    private final float lat;            //Latitud de la localizacion
    private final float lon;            //Longitud de la localizacion
    private TipoPiso TIPOPISO;          //Tipo de piso de la localizacion, pudiendo ser SOTANO, PISO_0, PISO_1, PISO_2,
                                        //  PISO_3 y PISO_4
    private TipoEdificio TIPOEDIFICIO;  //Tipo de edificio de la localizacion, pudiendo ser ADA_BYRON, TORRES_QUEVEDO
                                        //  y BETANCOURT

    public Localizacion (float lat, float lon, TipoPiso tipoPiso, TipoEdificio tipoEdificio) {
        this.lat = lat;
        this.lon = lon;
        this.TIPOPISO = tipoPiso;
        this.TIPOEDIFICIO = tipoEdificio;
    }

    //GETTERs
    public float getLat() { return lat; }

    public float getLon() { return lon; }

    public TipoPiso getPiso() {
        return TIPOPISO;
    }

    public TipoEdificio getEdificio() { return TIPOEDIFICIO; }
}
