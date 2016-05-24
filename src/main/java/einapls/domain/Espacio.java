package einapls.domain;

/**
 * Created by javmu on 24/05/2016.
 */
public class Espacio {

    private int id;
    private int capacidad;
    private int ocupacion;
    private TipoEspacio tipo;

    Espacio (int id, int capacidad, int ocupacion, TipoEspacio tipo){
        this.id = id;
        this.capacidad = capacidad;
        this.ocupacion = ocupacion;
        this.tipo = tipo;
    }

    public void incrementarOcupacion() {
        ocupacion++;
    }

    public void decrementarOcupacion() {
        ocupacion--;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public TipoEspacio getTipo() {
        return tipo;
    }



}
