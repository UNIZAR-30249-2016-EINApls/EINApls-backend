package einapls.domain;

/**
 * Created by Jorge on 14/04/2016.
 */
public class Laboratorio {

    private int id;
    public final String PISO;
    public final String EDIFICIO;
    public final int CAPACIDAD;
    private boolean disponibilidad;
    private int ocupacion;
    private boolean esBiblioteca;


    Laboratorio(int myId, String myPiso, String myEdificio, int myCapacidad, boolean myDisponibilidad, boolean myEsBiblioteca){
        id=myId;
        PISO=myPiso;
        EDIFICIO=myEdificio;
        CAPACIDAD=myCapacidad;
        disponibilidad=myDisponibilidad;
        ocupacion=0;
        esBiblioteca=myEsBiblioteca;
    }

    //GETTERS
    public boolean isEsBiblioteca() {
        return esBiblioteca;
    }

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
