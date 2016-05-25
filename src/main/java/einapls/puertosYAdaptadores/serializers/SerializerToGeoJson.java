package einapls.puertosYAdaptadores.serializers;

import einapls.domain.Espacio;
import einapls.domain.Incidencia;
import einapls.domain.MaquinaExpendedora;

/**
 * Created by Jorge on 25/05/2016.
 */
public class SerializerToGeoJson {


    private Espacio[] espacios = null;
    private Incidencia[] incidencias = null;
    private MaquinaExpendedora[] maquinas = null;

    public SerializerToGeoJson(Espacio[] espacios){ this.espacios = espacios; }
    public SerializerToGeoJson(Incidencia[] incidencias){ this.incidencias = incidencias; }
    public SerializerToGeoJson(MaquinaExpendedora[] maquinas){ this.maquinas = maquinas; }

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
        boolean esUltimo = false;

        if(!espacios.equals(null)){
            //ESPACIOS
            if(espacios.length>0){
                for(int i=0;i<espacios.length;i++){
                    if(i==(espacios.length-1)){ esUltimo=true; }
                    bodyGeoJson = bodyGeoJson + EspacioSerializer.serializeFeatureEspacio(espacios[i],esUltimo);
                }
            }
        }else if(!incidencias.equals(null)){
            //INCIDENCIAS
            if(incidencias.length>0){
                for(int i=0;i<incidencias.length;i++){
                    if(i==(incidencias.length-1)){ esUltimo=true; }
                    bodyGeoJson = bodyGeoJson + IncidenciaSerializer.serializeFeatureIncidencia(incidencias[i],esUltimo);
                }
            }
        }else{
            //MAQINAS
            if(maquinas.length>0){
                for(int i=0;i<maquinas.length;i++){
                    if(i==(maquinas.length-1)){ esUltimo=true; }
                    bodyGeoJson = bodyGeoJson + MaquinaSerializer.serializeFeatureMaquinaExpendedora(maquinas[i],esUltimo);
                }
            }
        }

        return inicioGeoJson+bodyGeoJson+finGeoJson;
    }
}
