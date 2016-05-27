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

    //Cada 10 s, Incrementara la ocupacion en 2 y 10 s despues la decrementa en 1
    @Override
    public void run() {
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
