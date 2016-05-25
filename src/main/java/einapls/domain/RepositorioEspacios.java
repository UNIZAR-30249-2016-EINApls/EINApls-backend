package einapls.domain;

import einapls.domain.enumerations.TipoEdificio;
import einapls.infrastructure.PoolConexiones;

import java.sql.*;

/**
 * Clase que se comunicará con e respositorio donde se encuentran los espacios
 */
public class RepositorioEspacios {

    //// TODO: 25/05/2016 TODO la implementacion, actualmente todo falseado
    public static Espacio findEspacio (int id) {
        Statement stmt = null;
        Connection con = PoolConexiones.getConex();
        try {
            stmt = con.createStatement();
            PreparedStatement query = con.prepareStatement("SELECT * FROM adabyron_0");

            ResultSet rs = query.executeQuery();
            String id_centro = "";
            while(rs.next()) {
                long idd = rs.getLong("id");
                String geom = rs.getString("geom");
                String layer = rs.getString("layer");
                String id_utc = rs.getString("id_utc");
                id_centro = rs.getString("id_centro");
                String tipo_de_uso = rs.getString("tipo_de_us");
                String area_gem = rs.getString("area_geom");
                System.out.println("IDD: " + idd);

                if (id_centro.startsWith("AULA") || id_centro.startsWith("LABORATORIO")) {

                    // INSERTAR EN TABLA ESPACIO CON NUEVOS CAMPOS (OCUPACION, ETC).
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;

    }

    public static Espacio[] findEspacios (TipoEdificio tipoEdificio, int id) {
        return null;
    }
}
