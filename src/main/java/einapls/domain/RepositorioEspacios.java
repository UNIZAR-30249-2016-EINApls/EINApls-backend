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
            PreparedStatement query = con.prepareStatement("SELECT * FROM adabyron_0 WHERE id = ?");
            query.setString(1, id+"");

            ResultSet rs = query.executeQuery();
            int idd = rs.getInt("id");
            String geom = rs.getString("geom");
            String layer = rs.getString("layer");
            String id_utc = rs.getString("id_utc");
            String id_centro = rs.getString("id_centro");
            String tipo_de_uso = rs.getString("tipo_de_us");
            String area_gem = rs.getString("area_gem");

            System.out.println("ID_CENTRO: " + id_centro);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;

    }

    public static Espacio[] findEspacios (TipoEdificio tipoEdificio, int id) {
        return null;
    }
}
