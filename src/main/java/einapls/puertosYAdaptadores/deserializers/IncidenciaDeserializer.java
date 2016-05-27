package einapls.puertosYAdaptadores.deserializers;

import einapls.domain.Incidencia;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by Jorge on 25/05/2016.
 */
public class IncidenciaDeserializer {

    public Incidencia deserializeFeatureIncidencia(String geoJsonIncidencia){


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
        geoJsonIncidencia.indexOf("geometry");

        //Para extraer las propiedas del GeoJson
        geoJsonIncidencia.indexOf("properties");
        JsonObject jsonProperties = new JsonParser().parse(geoJsonIncidencia).getAsJsonObject();
        jsonProperties.get("titulo");
        return null;
    }

}
