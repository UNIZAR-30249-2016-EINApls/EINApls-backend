package einapls.puertosYAdaptadores;

import java.sql.*;

/**
 * Pool de conexiones, gestiona la conexion con postgreSQL
 */
public class PoolConexiones {
    static Connection connection = null;

    //Establece conexion a la bd postgreSQL
    public static Connection getConex () {
        if(connection==null){
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your PostgreSQL JDBC Driver? "
                        + "Include in your library path!");
                e.printStackTrace();
                return null;
            }
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://85.251.93.32:5432/einapls_db", "einapls",
                        "einaplsvm");

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            if (connection != null) {
                return connection;
            } else {
                System.out.println("Failed to make connection!");
                return null;
            }
        }else{
            return connection;
        }
    }
}
