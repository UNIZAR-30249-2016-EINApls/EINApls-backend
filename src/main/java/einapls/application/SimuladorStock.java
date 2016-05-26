package einapls.application;

import einapls.domain.MaquinaExpendedora;

import java.util.HashMap;

/**
 * Simulador del stock de las maquinas expendedoras
 */
public class SimuladorStock implements Runnable{
    MaquinaExpendedora me;
    SimuladorStock(MaquinaExpendedora me){
        this.me = me;
    }
    @Override
    public void run() {
        HashMap<String, Integer> hm = me.getAllStock();
        //TODO me.incrementarStock();
    }
}
