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

    //Incrementa el stock de todos los items cada 10 s, 10s despues lo decrementa en 1
    @Override
    public void run() {
        while(true){
            HashMap<String, Integer> hm = me.getAllStock();
            Iterator<String> it = hm.keySet().iterator();
            if(it.hasNext()){
                try {
                    String s = it.next();
                    Thread.sleep(10000);
                    me.incrementarStock(s);
                    Thread.sleep(10000);
                    me.decrementarStock(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
