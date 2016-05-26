package einapls.application;

import einapls.domain.MaquinaExpendedora;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Simulador del stock de las maquinas expendedoras
 */
public class SimuladorStock implements Runnable{
    MaquinaExpendedora me;
    public SimuladorStock(MaquinaExpendedora me){
        this.me = me;
    }
    @Override
    public void run() {
        while(true){
            HashMap<String, Integer> hm = me.getAllStock();
            Iterator<String> it = hm.keySet().iterator();
            if(it.hasNext()){
                try {
                    String s = it.next();
                    wait(10000);
                    me.incrementarStock(s);
                    wait(10000);
                    me.decrementarStock(s);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
