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

    public Localizacion(String lat, String lon, String tipoPiso, String tipoEdificio){
        TIPOPISO = ConversorEnum.getTipoPiso(tipoPiso);
        /*if(tipoPiso.equals("PISO_0")){
            tp = TipoPiso.PISO_0;
        }else if(tipoPiso.equals("PISO_1")){
            tp = TipoPiso.PISO_1;
        }else if(tipoPiso.equals("PISO_2")){
            tp = TipoPiso.PISO_2;
        }else if(tipoPiso.equals("PISO_3")){
            tp = TipoPiso.PISO_3;
        }else if(tipoPiso.equals("PISO_4")){
            tp = TipoPiso.PISO_4;
        }else if(tipoPiso.equals("SOTANO")){
            tp = TipoPiso.SOTANO;
        }
        TIPOPISO = tp;
        */
        TIPOEDIFICIO = ConversorEnum.getTipoEdificio(tipoEdificio);
        /*
        TipoEdificio te = null;
        if(tipoEdificio.equals("ADA_BYRON")){
            te = TipoEdificio.ADA_BYRON;
        }else if(tipoPiso.equals("TORRES_QUEVEDO")){
            te = TipoEdificio.TORRES_QUEVEDO;
        }else if(tipoPiso.equals("BETANCOURT")){
            te = TipoEdificio.BETANCOURT;
        }
        TIPOEDIFICIO = te;
        */
        this.lon = Long.parseLong(lon);
        this.lat = Long.parseLong(lat);
    }

    //GETTERs
    public float getLat() { return lat; }

    public float getLon() { return lon; }

    public TipoPiso getPiso() {
        return TIPOPISO;
    }

    public TipoEdificio getEdificio() { return TIPOEDIFICIO; }

}
