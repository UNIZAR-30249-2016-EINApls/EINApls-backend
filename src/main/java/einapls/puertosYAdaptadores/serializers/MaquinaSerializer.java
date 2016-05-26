package einapls.puertosYAdaptadores.serializers;

import einapls.domain.Localizacion;
import einapls.domain.MaquinaExpendedora;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

import java.util.HashMap;
import java.util.Set;
import java.util.Enumeration;

/**
 * Serializador de una Maquina Expendedora, dado un Array de Maquina Expendedora devolverá un GeoJson con la información
 * de todos ellas
 */
public class MaquinaSerializer {


    private MaquinaExpendedora[] maquinas;

    public MaquinaSerializer(MaquinaExpendedora[] maquinas){
        this.maquinas = maquinas;
    }
/*
    public String serializeToGeoJson(){

        /*Formateamos un nuevo GeoJson con los datos obtenidos siguiendo el siguiente formato:
            {
                "type": "FeatureCollection",
                "features": ['bodyGeoJson']
            }
         *//*
        String inicioGeoJson = "{" +
                "\"type\" : \"FeatureCollection\"," +
                "\"features\": [";
        String finGeoJson = "]}";
        String bodyGeoJson="";
        if(maquinas.length>0){
            boolean esUltimo = false;
            //Recorremos el array de espacios
            for(int i=0;i<maquinas.length;i++){
                if(i==(maquinas.length-1)){
                    esUltimo=true;
                }
                bodyGeoJson = bodyGeoJson + serializeFeatureMaquinaExpendedora(maquinas[i],esUltimo);
            }
        }
        return inicioGeoJson+bodyGeoJson+finGeoJson;
    }
*/


    public static String serializeFeatureMaquinaExpendedora(MaquinaExpendedora maquina, boolean esUltimo){
        //Cargamos los datos de la Maquina Expendedora
        HashMap<String, Integer> stock = maquina.getAllStock();

        //Cargamos la localizacion de la Maquina Expendedora
        Localizacion localizacion = maquina.getLocalizacion();
        float lat = localizacion.getLat();
        float lon = localizacion.getLon();
        TipoPiso tipoPiso = localizacion.getPiso();
        TipoEdificio tipoEdificio = localizacion.getEdificio();

        //Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
        // ('=>variable java, no hay que poner  ')
            /*
            { "type": "Feature",
                "geometry": {"type": "Point", "coordinates": ['lat', 'lon']},
                "properties": {
                    "stock": {
                        "'key1'": "'value1'",
                        "'key2'": "'value2'"
                     },
                    "tipoPiso": "'tipoEspacio'",
                    "tipoEdificio": "'tipoEspacio'"
                }
             },
             */

        //todo HACER ESTO

        String feaureIncidencia = "{ \"type\": \"Feature\", " +
                    "\"geometry\": { \"type\": \"Point\", \"coordinates\": [" + lat + ", " + lon + "]}, " +
                    "\"properties\": {" +
                        "\"stock\": {}" +
                        "\"tipoPiso\": \"" + tipoPiso +"\"," +
                        "\"tipoEdificio\": \"" + tipoEdificio +"\"" +
                    "}" +
                "},";
        //Eliminamos la ',' sobrante al final de bodyGeoJson
        if(esUltimo){
            feaureIncidencia = feaureIncidencia.substring(0,feaureIncidencia.length()-2);
        }
        return  feaureIncidencia;
    }



}
