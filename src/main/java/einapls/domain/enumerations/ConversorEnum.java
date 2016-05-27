package einapls.domain.enumerations;

/**
 * Clase encargada de convertir de String al correspondiente tipo asociado
 */
public class ConversorEnum {

    //CONVERSIÓN TIPO DE ESPACIO
    public static TipoEspacio getTipoEspacio (String tipoEspacioString) {
        TipoEspacio tipoEspacio = TipoEspacio.AULA;
        if (tipoEspacioString.equals("BIBLIOTECA")) {
            tipoEspacio  = TipoEspacio.BIBLIOTECA;
        }
        else if (tipoEspacioString.equals("CAFETERIA")) {
            tipoEspacio  = TipoEspacio.CAFETERIA;
        }
        else if (tipoEspacioString.equals("LABORATORIO")) {
            tipoEspacio  = TipoEspacio.LABORATORIO;
        }
        else if (tipoEspacioString.equals("SALA_DE_ESTUDIO")) {
            tipoEspacio  = TipoEspacio.SALA_DE_ESTUDIO;
        }
        return tipoEspacio;
    }

    //CONVERSIÓN TIPO DE PISO
    public static TipoPiso getTipoPiso (String tipoPisoString) {
        TipoPiso tipoPiso =  TipoPiso.SOTANO;
        if (tipoPisoString.equals("PISO_0")) {
            tipoPiso = TipoPiso.PISO_0;
        }
        else if (tipoPisoString.equals("PISO_1")) {
            tipoPiso = TipoPiso.PISO_1;
        }
        else if (tipoPisoString.equals("PISO_2")) {
            tipoPiso = TipoPiso.PISO_2;
        }
        else if (tipoPisoString.equals("PISO_3")) {
            tipoPiso = TipoPiso.PISO_3;
        }
        else if (tipoPisoString.equals("PISO_4")) {
            tipoPiso = TipoPiso.PISO_4;
        }
        return tipoPiso;
    }

    //CONVERSIÓN TIPO DE EDIFICIO
    public static TipoEdificio getTipoEdificio (String tipoEdificioString) {
        TipoEdificio tipoEdificio =  TipoEdificio.ADA_BYRON;
        if (tipoEdificioString.equals("TORRES_QUEVEDO")) {
            tipoEdificio = TipoEdificio.TORRES_QUEVEDO;
        }
        else if (tipoEdificioString.equals("BETANCOURT")) {
            tipoEdificio = TipoEdificio.BETANCOURT;
        }
        return tipoEdificio;
    }

    //CONVERSIÓN ESTADO INCIDENCIA
    public static EstadoIncidencia getEstadoIncidencia (String estadoIncidenciaString) {
        EstadoIncidencia tipoIncidencia =  EstadoIncidencia.ABIERTA;
        if (estadoIncidenciaString.equals("ACEPTADA")) {
            tipoIncidencia = EstadoIncidencia.ACEPTADA;
        }else if(estadoIncidenciaString.equals("CERRADA")){
            tipoIncidencia = EstadoIncidencia.CERRADA;
        }
        return tipoIncidencia;
    }
}
