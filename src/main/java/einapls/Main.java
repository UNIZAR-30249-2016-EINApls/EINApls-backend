package einapls;

import einapls.domain.MaquinaExpendedora;
import einapls.domain.RepositorioMaquinas;
import einapls.puertosYAdaptadores.Server;
import org.glassfish.grizzly.Grizzly;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static MaquinaExpendedora[] mes; //Bastante guarrada creo
    private static final Logger LOGGER = Grizzly.logger(Main.class);

    public static void main(String [] args) {
        LOGGER.setLevel(Level.FINER);
        try (Scanner scan = new Scanner(System.in)){
            Server.startServer();
            //Start Espacios
            /*Espacio[] esps = RepositorioEspacios.findAllEspacios();
            //TODO solo coge 5 espacios
            for(int i=0; i<5; i++){
                (new Thread(new SimuladorES(esps[i]))).start();
            }*/

            //Start Maquinas
            mes = RepositorioMaquinas.findAllMaquinas(); //solo coje ada
            HashMap<String, Integer> hm = new HashMap<>();
            hm.put("Patatas",3);
            hm.put("Chocolate",4);
            for(int i=0; i<mes.length; i++){
                mes[i].setStock(hm);
                //(new Thread(new SimuladorStock(mes[i]))).start();
            }

            LOGGER.info("Press 's'+'enter' to shutdown now the server...");
            while(!scan.nextLine().equals("s"));
        } catch (IOException ioe) {
            LOGGER.log(Level.SEVERE, ioe.toString(), ioe);
        } finally {
            LOGGER.info("Shuting down");
            Server.stopServer();
            LOGGER.info("Server stopped");
        }
    }

    public static MaquinaExpendedora[] dameStockMaquinas(){
        return mes;
    }
}
