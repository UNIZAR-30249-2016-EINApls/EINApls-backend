package einapls.domain;

import einapls.domain.enumerations.TipoEspacio;

/**
 * Representará un Espacio
 */
public class Espacio {

    private int id;                 //Id único
    private final int capacidad;    //Capacidad total del espacio
    private int ocupacion;          //Ocupacion actual del espacio, se actualizara cuando asi lo indique un sensor
    private TipoEspacio TIPO;       //Tipo de espacio, a diferenciar entre AULA, LABORATORIO, SALA_DE_ESTUDIO, BIBLIOTECA
                                    // y CAFETERIA.

    Espacio (int id, int capacidad, int ocupacion, TipoEspacio tipo){
        this.id = id;
        this.capacidad = capacidad;
        this.ocupacion = ocupacion;
        this.TIPO = tipo;
    }

   //GETTERs

    public int getId() { return id; }

    public int getOcupacion() {
        return ocupacion;
    }

    public TipoEspacio getTipo() {
        return TIPO;
    }

    //SETTERs
    public void incrementarOcupacion() {
        ocupacion++;
    }

    public void decrementarOcupacion() {
        ocupacion--;
    }



}
