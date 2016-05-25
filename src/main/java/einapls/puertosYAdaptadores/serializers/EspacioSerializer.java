package einapls.puertosYAdaptadores.serializers;

import einapls.domain.Espacio;
import einapls.domain.Localizacion;
import einapls.domain.enumerations.TipoEspacio;

/**
 * Created by Jorge on 25/05/2016.
 */
public class EspacioSerializer {


    private Espacio[] espacios;

    public EspacioSerializer(Espacio[] espacios){ this.espacios=espacios; }

    public String serializeToGeoJson(){

        /*Formateamos un nuevo GeoJson con los datos obtenidos siguiendo el siguiente formato:
            {
                "type": "FeatureCollection",
                "features": ['bodyGeoJson']
            }
         */
        String inicioGeoJson = "{" +
                "\"type\" : \"FeatureCollection\"," +
                "\"features\": [";
        String finGeoJson = "]}";
        String bodyGeoJson="";
        if(espacios.length>0){
            boolean esUltimo = false;
            //Recorremos el array de espacios
            for(int i=0;i<espacios.length;i++){
                if(i==(espacios.length-1)){
                    esUltimo=true;
                }
                bodyGeoJson = bodyGeoJson + serializeFeatureEspacio(espacios[i],esUltimo);
            }
        }
        return inicioGeoJson+bodyGeoJson+finGeoJson;
    }

    public String serializeFeatureEspacio(Espacio espacio, boolean esUltimo){
        //Cargamos los datos del espacio
        int id = espacio.getId();
        int ocupacion = espacio.getOcupacion();
        TipoEspacio tipoEspacio = espacio.getTipo();

        //Cargamos la localizacion del espacio
        Localizacion localizacion = espacio.getLocalizacion();
        float coordX = localizacion.getCoordX();
        float coordY = localizacion.getCoordY();

        /*Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
            { "type": "Feature",
                "geometry": {"type": "Point", "coordinates": ['coordX', 'coordY']},
                "properties": {
                    "id": "'id'",
                    "ocupacion":"'ocupacion'",
                    ""tipoEspacio:"'tipoEspacio'"
                }
             },
         */
        String feaureEspacio = "{ \"type\": \"Feature\", " +
                    "\"geometry\": { \"type\": \"Point\", \"coordinates\": [" + coordX + ", " + coordY + "]}, " +
                    "\"properties\": {" +
                        "\"id\": \"" + titulo + "\"," +
                        "\"ocupacion\": \"" + estadoIncidencia.toString() + "\"," +
                        "\"foto\": \"" + foto + "\"," +
                        "\"descripcion\": \"" + descripcion +"\"" +
                    "}" +
                "},";
        //Eliminamos la ',' sobrante al final de bodyGeoJson
        if(esUltimo){
            feaureEspacio = feaureEspacio.substring(0,feaureEspacio.length()-2);
        }
        return  feaureEspacio;
    }










}
