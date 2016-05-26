package einapls.puertosYAdaptadores.deserializers;

import einapls.domain.Incidencia;

/**
 * Created by Jorge on 25/05/2016.
 */
public class IncidenciaDeserializer {

    public Incidencia deserializeFeatureIncidencia(Incidencia incidencia, boolean esUltimo){


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
         *//*
         * /*Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
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
         */
        
        return null;
    }

}
