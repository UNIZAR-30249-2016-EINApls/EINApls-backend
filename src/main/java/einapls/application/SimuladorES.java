package einapls.application;

import einapls.domain.Espacio;

/**
 * Simulador de Enrada salida de los distintos espacios
 */
public class SimuladorES implements Runnable{

    Espacio espacio;
    public SimuladorES(Espacio espacio){
        this.espacio = espacio;
    }
    @Override
    public void run() {
        /*for(int i=0; i<10; i++){
            espacio.incrementarOcupacion();
        }*/

        while(true){
            try {
                Thread.sleep(10000);
                espacio.incrementarOcupacion();
                espacio.incrementarOcupacion();
                Thread.sleep(10000);
                espacio.decrementarOcupacion();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
