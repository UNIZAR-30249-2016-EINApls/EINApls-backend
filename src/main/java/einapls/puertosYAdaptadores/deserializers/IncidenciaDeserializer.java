package einapls.puertosYAdaptadores.deserializers;

import einapls.domain.Incidencia;

/**
 * Created by Jorge on 25/05/2016.
 */
public class IncidenciaDeserializer {

    public Incidencia deserializeFeatureIncidencia(Incidencia incidencia, boolean esUltimo){


         /*Formateamos un nuevo GeoJson con los datos obtenidos siguiendo el siguiente formato:
            {
                "type": "FeatureCollection",
                "features": ['bodyGeoJson']
            }
         *//*
         * /*Formateamos un nuevo punto con los datos obtenidos siguiendo el siguiente formato
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
        
        return null;
    }

}
