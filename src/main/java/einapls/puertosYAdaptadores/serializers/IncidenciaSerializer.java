package einapls.puertosYAdaptadores.serializers;

import einapls.domain.Incidencia;
import einapls.domain.Localizacion;
import einapls.domain.enumerations.EstadoIncidencia;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

public class IncidenciaSerializer {

    private Incidencia[] incidencias;

    public IncidenciaSerializer(Incidencia[] incidencias){ this.incidencias = incidencias; }

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

    public static String serializeFeatureIncidencia(Incidencia incidencia, boolean esUltimo){
        //Cargamos los datos de la incidencia
        String titulo = incidencia.getTitulo();
        EstadoIncidencia estadoIncidencia = incidencia.getEstadoIncidencia();
        String foto = incidencia.getFoto();
        String descripcion = incidencia.getDescripcion();

        //Cargamos la localizacion de la incidencia
        Localizacion localizacion = incidencia.getLocalizacion();
        float lat = localizacion.getLat();
        float lon = localizacion.getLon();
        TipoPiso tipoPiso = localizacion.getPiso();
        TipoEdificio tipoEdificio = localizacion.getEdificio();

        /*Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
            { "type": "Feature",
                "geometry": {"type": "Point", "coordinates": ['lat', 'lon']},
                "properties": {
                    "titulo": "'titulo'",
                    "estadoIncidencia": "'estadoIncidencia.toString()'",
                    "foto": "'foto'",
                    "descripcion": "'descripcion'",
                    "tipoPiso": "'tipoEspacio'",
                    "tipoEdificio": "'tipoEspacio'"
                }
             },
         */
        String feaureIncidencia = "{ \"type\": \"Feature\", " +
                    "\"geometry\": { \"type\": \"Point\", \"coordinates\": [" + lat + ", " + lon + "]}, " +
                    "\"properties\": {" +
                        "\"titulo\": \"" + titulo + "\"," +
                        "\"estadoIncidencia\": \"" + estadoIncidencia.toString() + "\"," +
                        "\"foto\": \"" + foto + "\"," +
                        "\"descripcion\": \"" + descripcion +"\"," +
                        "\"tipoPiso\": \"" + tipoPiso +"\"," +
                        "\"tipoEdificio\": \"" + tipoEdificio +"\"" +
                    "}" +
                "},";
        //Eliminamos la ',' sobrante al final de bodyGeoJson
        if(esUltimo){
            feaureIncidencia = feaureIncidencia.substring(0,feaureIncidencia.length()-1);
        }
        return  feaureIncidencia;
    }

}
