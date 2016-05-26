package einapls.puertosYAdaptadores.serializers;

import einapls.domain.Espacio;
import einapls.domain.Localizacion;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoEspacio;
import einapls.domain.enumerations.TipoPiso;

/**
 * Serializador de un Espacio, dado un Array de Espacios devolverá un GeoJson con la información de todos ellos
 */
public class EspacioSerializer {


    private Espacio[] espacios;

    public EspacioSerializer(Espacio[] espacios){ this.espacios=espacios; }

    public static String serializeFeatureEspacio(Espacio espacio, boolean esUltimo){
        //Cargamos los datos del espacio
        int id = espacio.getId();
        int ocupacion = espacio.getOcupacion();
        TipoEspacio tipoEspacio = espacio.getTipo();

        //Cargamos la localizacion del espacio
        Localizacion localizacion = espacio.getLocalizacion();
        float lat = localizacion.getLat();
        float lon = localizacion.getLon();
        TipoPiso tipoPiso = localizacion.getPiso();
        TipoEdificio tipoEdificio = localizacion.getEdificio();

        /*Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
            { "type": "Feature",
                "geometry": {"type": "Point", "coordinates": ['lat', 'lon']},
                "properties": {
                    "id": 'id',
                    "ocupacion": 'ocupacion',
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
                        "\"ocupacion\": " + ocupacion + "," +
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
