package einapls.infrastructure;

import java.sql.*;

/**
 * Created by Marcos on 25/05/2016.
 */
public class PoolConexiones {
    static Connection connection = null;

    //Establece conexion a la bd postgreSQL
    public static Connection getConex () {
        //System.out.print(".");
        if(connection==null){
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your PostgreSQL JDBC Driver? "
                        + "Include in your library path!");
                e.printStackTrace();
                return null;
            }
            //System.out.println("PostgreSQL JDBC Driver Registered!");
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://85.251.93.32:5432/einapls_db", "einapls",
                        "einaplsvm");

            } catch (SQLException e) {
                //System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
            }
            if (connection != null) {
                //System.out.println("You made it, take control your database now!");
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
