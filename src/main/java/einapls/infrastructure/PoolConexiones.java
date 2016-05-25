package einapls.infrastructure;

import java.sql.*;

/**
 * Created by Marcos on 25/05/2016.
 */
public class PoolConexiones {
    /*
    Esto se conecta a la bd de postgresql
     */
    public static void main(String[] args){
        System.out.println("Trying");
        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://85.251.93.32:5432/einapls_db", "einapls",
                    "einaplsvm");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public static void select(Connection c) throws SQLException {
        Statement stmt = null;
        stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery( "SELECT * FROM einapls.espacio;" );
        while ( rs.next() ) {
            int id = rs.getInt(1);
            Array  ed = rs.getArray(2);
            String piso  = rs.getString(3);
            String  lat = rs.getString("lat");
            String lon = rs.getString("lon");
            System.out.println(id);
            System.out.println(ed);
            System.out.println(piso);
            System.out.println(lat);
        }
        rs.close();
        stmt.close();
        c.close();
    }
}
