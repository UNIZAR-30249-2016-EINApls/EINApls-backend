package einapls.application;

import einapls.Main;
import einapls.domain.MaquinaExpendedora;
import einapls.domain.RepositorioMaquinas;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.puertosYAdaptadores.serializers.SerializerToGeoJson;

import java.util.HashMap;

/**
 * Operaciones relacionadas con los Maquinas
 */
public class OperacionesMaquina {

    public static MaquinaExpendedora getMaquina(int id){
        //Llamamos a repositorio maquinas  para que nos devuelva la maquina con id id
        MaquinaExpendedora maquinaExpendedora = RepositorioMaquinas.findMaquina(id);

        //Obtiene stock
        MaquinaExpendedora[] maquinas_con_stock = Main.dameStockMaquinas();
        for(int i = 0; i<maquinas_con_stock.length; i++){
            if(maquinas_con_stock[i].getId()==id){
                maquinaExpendedora.setStock(maquinas_con_stock[i].getAllStock());
            }
        }
        System.out.println("----------------------------------");
        return maquinaExpendedora;

    }
    public static MaquinaExpendedora[] getMaquinas(TipoPiso tipoPiso, TipoEdificio tipoEdificio){
        //Llamamos a repositorio maquinas para que nos devuelva una lista con las maquinas en tipoEdificio y tipoPiso
        MaquinaExpendedora[] maquinas = RepositorioMaquinas.findMaquinas(tipoPiso,tipoEdificio);
        //Rellenamos el stock de las maquinas a devolver

        //Saco los stocks
        MaquinaExpendedora[] maquinas_con_stock = Main.dameStockMaquinas();
        for(int i=0; i<maquinas.length; i++){
            for(int j=0; j<maquinas_con_stock.length; j++){
                if(maquinas[i].getId() == maquinas_con_stock[j].getId()){
                    HashMap<String, Integer> hm = maquinas_con_stock[j].getAllStock();
                    maquinas[i].setStock(hm);
                }
            }
        }
        //Le pasamos el array de Maquinas al serializar para obtener un GeoJSon
        SerializerToGeoJson serializer = new SerializerToGeoJson(maquinas);
        String geoJsonEspacios = serializer.DoSerializeToGeoJson();
        return maquinas;

    }
}
