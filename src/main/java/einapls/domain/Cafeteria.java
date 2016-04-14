package einapls.domain;

/**
 * Created by Jorge on 14/04/2016.
 */
public class Cafeteria {
    private int id;
    public final String PISO;
    public final String EDIFICIO;
    public final int CAPACIDAD;
    private int ocupacion;

    Cafeteria(int myId, String myPiso, String myEdificio, int myCapacidad){
        id=myId;
        PISO=myPiso;
        EDIFICIO=myEdificio;
        CAPACIDAD=myCapacidad;
        ocupacion=0;
    }

    //Ocupaciones
    public void incrementarOcupacion(){
        ocupacion++;
    }

    public void decrementarOcupacion(){
        ocupacion--;
    }

    public int getOcupacion() {
        return ocupacion;
    }
}
