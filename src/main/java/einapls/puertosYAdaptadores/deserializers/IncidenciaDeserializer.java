package einapls.puertosYAdaptadores.deserializers;

import com.google.gson.JsonArray;
import einapls.domain.Incidencia;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import einapls.domain.Localizacion;
import einapls.domain.enumerations.ConversorEnum;
import einapls.domain.enumerations.EstadoIncidencia;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;

/**
 * Created by Jorge on 25/05/2016.
 */
public class IncidenciaDeserializer {

    public static Incidencia deserializeGeoJsonIncidencia(String geoJsonIncidencia){

         /*Dado:
            {
                "type": "FeatureCollection",
                "features": [
                    { "type": "Feature",
                    "geometry": {"type": "Point", "coordinates": ['coordX', 'coordY']},
                    "properties": {
                        "titulo": "'titulo'",
                        "estadoIncidencia": "'estadoIncidencia.toString()'",
                        "foto": "'foto'",
                        "descripcion": "'descripcion'",
                        "tipoPiso": "'tipoEspacio'",
                        "tipoEdificio": "'tipoEspacio'"
                    }
                   }
                ]
            }

            ej:
            {
                "type": "FeatureCollection",
                "features": [{
                    "type": "Feature",
                    "geometry": {
                        "type": "Point",
                        "coordinates": [123.321, 123.321]
                    },
                    "properties": {
                        "titulo": "Un titulo",
                        "estadoIncidencia": "ABIERTA",
                        "foto": "foto, una url",
                        "descripcion": "Una descripcion",
                        "tipoPiso": "'PISO_0'",
                        "tipoEdificio": "ADA_BYRON"
                    }
                }]
            }
         */

        //Pasamos nuestro String a un objeto Json
        JsonObject jsonObject = new JsonParser().parse(geoJsonIncidencia).getAsJsonObject();

        //Capturamos el campo de features, donde esatrán las coordenadas y propiedas de nuestra incidencia
        JsonArray jsonArrayFeatures = jsonObject.get("features").getAsJsonArray();

        //Extraemos las coordenadas
        // Notese que solo tendremos un solo elemento en el array de features con las propiedas de la incidencia
        JsonObject jsonGeometry = jsonArrayFeatures.get(0).getAsJsonObject().get("geometry").getAsJsonObject();
        float lat = jsonGeometry.get("coordinates").getAsJsonArray().get(0).getAsFloat();
        float lon = jsonGeometry.get("coordinates").getAsJsonArray().get(1).getAsFloat();

        //Extraemos los atributos
        JsonObject jsonProperties = jsonArrayFeatures.get(0).getAsJsonObject().get("properties").getAsJsonObject();
        String titulo = jsonProperties.get("titulo").getAsString();
        EstadoIncidencia estadoIncidencia = ConversorEnum.getEstadoIncidencia(jsonProperties.get("estadoIncidencia").getAsString());
        String foto = jsonProperties.get("foto").getAsString();
        String descripcion = jsonProperties.get("descripcion").getAsString();
        TipoPiso tipoPiso = ConversorEnum.getTipoPiso(jsonProperties.get("tipoPiso").getAsString());
        TipoEdificio tipoEdificio = ConversorEnum.getTipoEdificio(jsonProperties.get("tipoEdificio").getAsString());

        //Construimos la localizacion
        Localizacion localizacion =  new Localizacion(lat,lon,tipoPiso,tipoEdificio);

        //Contruimos la incidencia y la devolvemos (ID=0 porque cuando la cargamos por primera vez a la BD, se le asigna uno)
        Incidencia incidencia = new Incidencia(0,titulo,estadoIncidencia,foto,descripcion,localizacion);

        return incidencia;
    }

}
