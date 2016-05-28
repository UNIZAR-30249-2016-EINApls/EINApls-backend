package einapls.puertosYAdaptadores.serializers;

import einapls.domain.Disponibilidad;
import einapls.domain.Espacio;
import einapls.domain.Localizacion;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoEspacio;
import einapls.domain.enumerations.TipoPiso;

/**
 * Serializador de un Espacio, dado un Array de Espacios devolverá un GeoJson con la información de todos ellos
 */
public class EspacioSerializer {

    public static String serializeFeatureEspacio(Espacio espacio, boolean esUltimo){
        //Cargamos los datos del espacio
        int id = espacio.getId();
        int ocupacion = espacio.getOcupacion();
        int capacidad = espacio.getCapacidad();
        TipoEspacio tipoEspacio = espacio.getTipo();

        //Cargamos la localizacion del espacio
        Localizacion localizacion = espacio.getLocalizacion();
        float lat = localizacion.getLat();
        float lon = localizacion.getLon();
        TipoPiso tipoPiso = localizacion.getPiso();
        TipoEdificio tipoEdificio = localizacion.getEdificio();

        //// TODO: 28/05/2016  lo comentado de abajo es si no usamos el servicio disponbilidad, elimianr si eso
        //Calculamos la disponibilidad
        /*boolean disponibilidad = true;
        if(ocupacion >= capacidad){
            disponibilidad = false;
        }*/
        boolean disponibilidad= new Disponibilidad(espacio).isDisponible();
        /*Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
            { "type": "Feature",
                "geometry": {"type": "Point", "coordinates": ['lat', 'lon']},
                "properties": {
                    "id": 'id',
                    "disponibiliad": 'disponibiliad',
                    "ocupacion": 'ocupacion',
                    "capacidad": 'capacidad',
                    ""tipoEspacio: "'tipoEspacio'",
                    "tipoPiso": "'tipoEspacio'",
                    "tipoEdificio": "'tipoEspacio'"
                }
             },
         */
        String feaureEspacio = "{ \"type\": \"Feature\", " +
                    "\"geometry\": { \"type\": \"Point\", \"coordinates\": [" + lat + ", " + lon + "]}, " +
                    "\"properties\": {" +
                        "\"id\": " + id + "," +
                        "\"disponibilidad\": " + disponibilidad + "," +
                        "\"ocupacion\": " + ocupacion + "," +
                        "\"capacidad\": " + capacidad + "," +
                        "\"tipoEspacio\": \"" + tipoEspacio.toString() + "\", " +
                        "\"tipoPiso\": \"" + tipoPiso.toString() + "\", " +
                        "\"tipoEdificio\": \"" + tipoEdificio.toString() + "\" " +
                    "}" +
                "},";
        //Eliminamos la ',' sobrante al final de bodyGeoJson
        if(esUltimo){
            feaureEspacio = feaureEspacio.substring(0,feaureEspacio.length()-1);
        }
        return  feaureEspacio;
    }
}
