package einapls.domain;

import einapls.domain.enumerations.TipoEspacio;
import einapls.infrastructure.PoolConexiones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Representará un Espacio
 */
public class Espacio {

    private int id;                     //Id único
    private final int capacidad;        //Capacidad total del espacio
    private int ocupacion;              //Ocupacion actual del espacio, se actualizara cuando asi lo indique un sensor
    private TipoEspacio TIPO;           //Tipo de espacio, a diferenciar entre AULA, LABORATORIO, SALA_DE_ESTUDIO,
                                        //  BIBLIOTECA y CAFETERIA.
    private Localizacion localizacion;  //Localizacion asociada a este espacio

    public Espacio (int id, int capacidad, int ocupacion, TipoEspacio tipo, Localizacion localizacion){
        this.id = id;
        this.capacidad = capacidad;
        this.ocupacion = ocupacion;
        this.TIPO = tipo;
        this.localizacion = localizacion;
    }

   //GETTERs

    public int getId() { return id; }

    public int getOcupacion() {
        return ocupacion;
    }

    public int getCapacidad() { return capacidad; }

    public TipoEspacio getTipo() {
        return TIPO;
    }

    public Localizacion getLocalizacion() { return localizacion; }

    //SETTERs
    public void incrementarOcupacion() {
        ocupacion++;
        actualizarBD();
    }

    public void decrementarOcupacion() {
        ocupacion--;
        actualizarBD();
    }
    public void actualizarBD(){
        //TODO no deja
        Statement stmt = null;
        Connection con = PoolConexiones.getConex();
        try {
            stmt = con.createStatement();
            String sql = "UPDATE einapls.espacio SET ocupacion=" + ocupacion + " WHERE id=" + id + ";";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
