package einapls;

import einapls.domain.Espacio;
import einapls.domain.MaquinaExpendedora;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

import static einapls.domain.RepositorioEspacios.findAllEspacios;
import static einapls.domain.RepositorioMaquinas.findAllMaquinas;

/**
 * Created by Marcos on 28/05/2016.
 */
public class SimuladoresTest {
    @Test
    public void testEspacioEntra() {
        Espacio[] es = findAllEspacios();
        int oc1 = es[1].getOcupacion();
        es[1].incrementarOcupacion();
        int oc2 = es[1].getOcupacion();
        Assert.assertEquals(oc1+1,oc2);
    }
    @Test
    public void testEspacioSale(){
        Espacio[] es = findAllEspacios();
        int oc1 = es[1].getOcupacion();
        es[1].decrementarOcupacion();
        int oc2 = es[1].getOcupacion();
        Assert.assertEquals(oc1-1,oc2);
    }
    @Test
    public void testMaquinaCompra(){
        MaquinaExpendedora[] mes = findAllMaquinas();
        String KEY_MODIFIED = "Chocolate";
        HashMap<String, Integer> hm = mes[0].getAllStock();
        hm.put(KEY_MODIFIED, 4);
        hm.put("Patatas",3);
        mes[0].setStock(hm);
        mes[0].decrementarStock(KEY_MODIFIED);

        Iterator<String> it1 = mes[0].getAllStock().keySet().iterator();

        while(it1.hasNext()){
            String key1 = it1.next();
            int i2 = mes[0].getAllStock().get(key1);
            if(key1.equals(KEY_MODIFIED)){
                Assert.assertEquals(3,i2);
            }else{
                Assert.assertEquals(3,i2);
            }
        }
    }
    @Test
    public void testMaquinaRellena(){
        MaquinaExpendedora[] mes = findAllMaquinas();
        String KEY_MODIFIED = "Chocolate";
        HashMap<String, Integer> hm = mes[0].getAllStock();
        hm.put(KEY_MODIFIED, 4);
        hm.put("Patatas",3);
        mes[0].setStock(hm);

        mes[0].incrementarStock(KEY_MODIFIED);

        Iterator<String> it1 = mes[0].getAllStock().keySet().iterator();

        while(it1.hasNext()){
            String key1 = it1.next();
            int i2 = mes[0].getAllStock().get(key1);
            if(key1.equals(KEY_MODIFIED)){
                Assert.assertEquals(5,i2);
            }else{
                Assert.assertEquals(3,i2);
            }
        }
    }

}
