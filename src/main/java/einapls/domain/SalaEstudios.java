package einapls.domain;

/**
 * Created by Jorge on 14/04/2016.
 */
public class SalaEstudios {

    private int id;
    public final String PISO;
    public final String EDIFICIO;
    public final int CAPACIDAD;
    private boolean disponibilidad;
    private int ocupacion;


    SalaEstudios(int myId, String myPiso, String myEdificio, int myCapacidad, boolean myDisponibilidad){
        id=myId;
        PISO=myPiso;
        EDIFICIO=myEdificio;
        CAPACIDAD=myCapacidad;
        disponibilidad=myDisponibilidad;
        ocupacion=0;
    }

    //GETTERS

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    //SETTERS

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    //Ocupaciones
    public void incrementarOcupacion(){
        ocupacion++;
        if(ocupacion >= CAPACIDAD){
            setDisponibilidad(false);
        }
    }

    public void decrementarOcupacion(){
        ocupacion--;
        if(ocupacion < CAPACIDAD){
            setDisponibilidad(true);
        }
    }

    public int getOcupacion() {
        return ocupacion;
    }
}
