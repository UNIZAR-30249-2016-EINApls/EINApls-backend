package einapls.domain;

import einapls.infrastructure.PoolConexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servicio que nos indicará si un determinado espacio, diferenciado por su id, esta disponible o no.
 */
public class Disponibilidad {
    //// TODO: 25/05/2016 calcular la disponibilidad se podria hacer en el frontend, si lo hacemos en el back en seria on esto
    //// TODO: TODO si usamos esto al final habria que actualizar los geojsones de espacio para que la devolvieran

    private Espacio espacio;

    public Disponibilidad(Espacio espacio){
        this.espacio = espacio;
    }

    public boolean isDisponible (int idEspacio) {
        boolean disponible = false;
        Connection con = PoolConexiones.getConex();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM espacio WHERE id = ?");
            ResultSet rs = query.executeQuery();

            //Cargamos la ocupacion y capacidad del espacio con id id
            int capacidad = -1;
            int ocupacion = -1;
            if (rs.next()) {
                capacidad = rs.getInt("capacidad");
                ocupacion = rs.getInt("ocupacion");
            }

            //Comprobamos la disponibilidad
            if(ocupacion >= capacidad){
                disponible = false;
            }else{
                disponible = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            disponible = false;
        }
        return disponible;


    }
}
