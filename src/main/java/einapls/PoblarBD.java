package einapls;

import einapls.infrastructure.PoolConexiones;

import java.sql.*;

/**
 * Created by javmu on 26/05/2016.
 */
public class PoblarBD {

    public static void poblarDB() {
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
    }
}
