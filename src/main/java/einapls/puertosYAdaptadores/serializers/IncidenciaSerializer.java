package einapls.puertosYAdaptadores.serializers;

import einapls.domain.Incidencia;
import einapls.domain.Localizacion;
import einapls.domain.enumerations.EstadoIncidencia;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

public class IncidenciaSerializer {

    public static String serializeFeatureIncidencia(Incidencia incidencia, boolean esUltimo){
        //Cargamos los datos de la incidencia
        int id = incidencia.getId();
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
                    "id": 'id'
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
                        "\"id\": \"" + id +"\"," +
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
