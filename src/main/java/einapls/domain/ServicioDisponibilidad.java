package einapls.domain;

//// TODO: 28/05/2016  elimnar los imports y todo lo que no usemos, una vez que tenga el visto bueno esto 
import einapls.infrastructure.PoolConexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// Servicio que nos indicará si un determinado espacio, esta disponible o no.
public class ServicioDisponibilidad {

    public static boolean isDisponible (Espacio espacio) {
        boolean disponible = true;
        if(espacio.getOcupacion() >= espacio.getCapacidad()){
            disponible = false;
        }
        return disponible;
    }

    //// TODO: 28/05/2016 NO LA USAMOS Y DEBERIAMOS BORRARLA, LO DEJO LO DE BORRARLA PARA EL FINAL, NO VAYA A SER QUEE
    //// TODO: 25/05/2016 calcular la disponibilidad se podria hacer en el frontend, si lo hacemos en el back en seria on esto
    //// TODO: TODO si usamos esto al final habria que actualizar los geojsones de espacio para que la devolvieran

   /* public boolean isDisponible (int idEspacio) {
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


    }*/
}