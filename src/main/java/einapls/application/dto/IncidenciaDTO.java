package einapls.application.dto;

import einapls.domain.Incidencia;
import einapls.domain.Localizacion;
import einapls.domain.enumerations.EstadoIncidencia;

/**
 * Data Transfer object de Incidencias
 */
public class IncidenciaDTO {

    private Incidencia[] incidencias;

    public IncidenciaDTO(Incidencia[] incidencias){ this.incidencias = incidencias; }

    public String serializeToGeoJson(){
        //Formateamos un nuevo GeoJson con los datos obtenidos siguiendo el siguiente formato
        // (' => variable java, no hay que poner  ')
        /*
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
        if(incidencias.length>0){
            boolean esUltimo = false;
            //Recorremos el array de espacios
            for(int i=0;i<incidencias.length;i++){
                if(i==(incidencias.length-1)){
                    esUltimo=true;
                }
                bodyGeoJson = bodyGeoJson + serializeFeatureIncidencia(incidencias[i],esUltimo);
            }
        }
        return inicioGeoJson+bodyGeoJson+finGeoJson;
    }

    //TODO puede ser interesante llamar a este metodo desde la clase plantas
    public String serializeFeatureIncidencia(Incidencia incidencia, boolean esUltimo){
        //Cargamos los datos de la incidencia
        String titulo = incidencia.getTitulo();
        EstadoIncidencia estadoIncidencia = incidencia.getEstadoIncidencia();
        String foto = incidencia.getFoto();
        String descripcion = incidencia.getDescripcion();

        //Cargamos la localizacion de la incidencia
        Localizacion localizacion = incidencia.getLocalizacion();
        float coordX = localizacion.getCoordX();
        float coordY = localizacion.getCoordY();

        //Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
        // ('=>variable java, no hay que poner  ')
            /*
            { "type": "Feature",
                "geometry": {"type": "Point", "coordinates": ['coordX', 'coordY']},
                "properties": {
                    "titulo": "'titulo'",
                    "estadoIncidencia": "'estadoIncidencia.toString()'",
                    "foto": "'foto'",
                    "descripcion": "'descripcion'"
                }
             },
             */
        String feaureIncidencia = "{ \"type\": \"Feature\", " +
                        "\"geometry\": { \"type\": \"Point\", \"coordinates\": [" + coordX + ", " + coordY + "]}, " +
                        "\"properties\": {" +
                            "\"titulo\": \"" + titulo + "\"," +
                            "\"estadoIncidencia\": \"" + estadoIncidencia.toString() + "\"," +
                            "\"foto\": \"" + foto + "\"," +
                            "\"descripcion\": \"" + descripcion +"\"" +
                        "}" +
                     "},";
        //Eliminamos la ',' sobrante al final de bodyGeoJson
        if(esUltimo){
            feaureIncidencia = feaureIncidencia.substring(0,feaureIncidencia.length()-2);
        }
        return  feaureIncidencia;
    }


    /*
     //Recorremos el array de espacios
            for(int i=0;i<incidencias.length;i++){
                //Cargamos los datos de la incidencia
                String titulo = incidencias[i].getTitulo();
                EstadoIncidencia estadoIncidencia = incidencias[i].getEstadoIncidencia();
                String foto = incidencias[i].getFoto();
                String descripcion = incidencias[i].getDescripcion();

                //Cargamos la localizacion de la incidencia
                Localizacion localizacion = incidencias[i].getLocalizacion();
                float coordX = localizacion.getCoordX();
                float coordY = localizacion.getCoordY();

                //Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
                // ('=>variable java, no hay que poner  ')
                /*
                { "type": "Feature",
                    "geometry": {"type": "Point", "coordinates": ['coordX', 'coordY']},
                    "properties": {
                        "titulo": "'titulo'",
                        "estadoIncidencia": "'estadoIncidencia.toString()'",
                        "foto": "'foto'",
                        "descripcion": "'descripcion'"
                    }
                 },
                 *//*
    String feaure = "{ \"type\": \"Feature\", " +
            "\"geometry\": { \"type\": \"Point\", \"coordinates\": [" + coordX + ", " + coordY + "]}, " +
            "\"properties\": {" +
            "\"titulo\": \"" + titulo + "\"," +
            "\"estadoIncidencia\": \"" + estadoIncidencia.toString() + "\"," +
            "\"foto\": \"" + foto + "\"," +
            "\"descripcion\": \"" + descripcion +"\"" +
            "}" +
            "}";
    //Si aun no hemos recorrido el array, añadimos una coma para poder seguir añadiendo elementos
    if(i < (incidencias.length-1)){
        feaure = feaure + ",";
    }
    bodyGeoJson=bodyGeoJson+feaure;
}
     */
}
