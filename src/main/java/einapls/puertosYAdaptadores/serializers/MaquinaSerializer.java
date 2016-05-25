package einapls.puertosYAdaptadores.serializers;

import einapls.domain.Localizacion;
import einapls.domain.MaquinaExpendedora;

import java.util.HashMap;

/**
 * Created by Jorge on 25/05/2016.
 */
public class MaquinaSerializer {


    private MaquinaExpendedora[] maquinas;

    public MaquinaSerializer(MaquinaExpendedora[] maquinas){
        this.maquinas = maquinas;
    }

    public String serializeToGeoJson(){
        //TODO Programar el get GEOJson de maquinas dto
        return null;
    }



    public String serializeFeatureMaquinaExpendedora(MaquinaExpendedora maquina, boolean esUltimo){
        //Cargamos los datos de la Maquina Expendedora
        HashMap<String, Integer> stock = maquina.getAllStock();

        //Cargamos la localizacion de la Maquina Expendedora
        Localizacion localizacion = maquina.getLocalizacion();
        float coordX = localizacion.getCoordX();
        float coordY = localizacion.getCoordY();

        //Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
        // ('=>variable java, no hay que poner  ')
            /*
            { "type": "Feature",
                "geometry": {"type": "Point", "coordinates": ['coordX', 'coordY']},
                "properties": {
                    "stock": {
                        "'key1'": "'value1'",
                        "'key2'": "'value2'"
                     }
                }
             },
             */




        String feaureIncidencia = "{ \"type\": \"Feature\", " +
                "\"geometry\": { \"type\": \"Point\", \"coordinates\": [" + coordX + ", " + coordY + "]}, " +
                "\"properties\": {" +
                "\"stock\": {}" +

                "}" +
                "},";
        //Eliminamos la ',' sobrante al final de bodyGeoJson
        if(esUltimo){
            feaureIncidencia = feaureIncidencia.substring(0,feaureIncidencia.length()-2);
        }
        return  feaureIncidencia;
    }



}
