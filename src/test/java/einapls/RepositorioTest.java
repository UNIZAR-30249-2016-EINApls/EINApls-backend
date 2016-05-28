package einapls;

import einapls.domain.Espacio;
import einapls.domain.MaquinaExpendedora;
import einapls.domain.RepositorioEspacios;
import einapls.domain.RepositorioMaquinas;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoEspacio;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Marcos on 28/05/2016.
 */
public class RepositorioTest {
    @Test
    public void testAllMaquinas() {
        MaquinaExpendedora[] mes= RepositorioMaquinas.findAllMaquinas();
        boolean good = true;
        for(int i=0; i<mes.length; i++){
            int idMax = 100;
            if(mes[i].getId()>idMax){
                good = false;
            }

            HashMap<String, Integer> hm = mes[i].getAllStock();
            Iterator<String> it = hm.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                if(!(key=="Chocolate" || key == "Patatas")){
                    good = false;
                }
                hm.get(key);
            }
        }
        Assert.assertTrue(good);
    }

    @Test
    public void testAllEspacios(){
        Espacio[] es= RepositorioEspacios.findAllEspacios();
        boolean good = true;
        for(int i=0; i<es.length; i++){
            int idMax = 30000;
            TipoEspacio tes = es[i].getTipo();
            TipoEdificio ted = es[i].getLocalizacion().getEdificio();
            if(es[i].getId()>idMax){
                good = false;
            }
            if(!(tes == TipoEspacio.AULA || tes== TipoEspacio.BIBLIOTECA ||
                    tes== TipoEspacio.LABORATORIO || tes== TipoEspacio.CAFETERIA)){
                good =false;
            }
            if(!(ted== TipoEdificio.ADA_BYRON || ted== TipoEdificio.BETANCOURT ||
                    ted== TipoEdificio.TORRES_QUEVEDO)) {
                good =false;
            }

        }
        Assert.assertTrue(good);
    }
}
