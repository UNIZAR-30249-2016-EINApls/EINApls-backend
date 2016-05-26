package einapls;

import einapls.application.SimuladorES;
import einapls.application.SimuladorStock;
import einapls.domain.Espacio;
import einapls.domain.MaquinaExpendedora;
import einapls.domain.RepositorioEspacios;
import einapls.domain.RepositorioMaquinas;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
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
            Espacio[] esps1 = RepositorioEspacios.findEspacios(TipoPiso.PISO_0, TipoEdificio.ADA_BYRON);
            for(int i=0; i<5; i++){
                (new Thread(new SimuladorES(esps1[i]))).start();
            }
            /*Espacio[] esps2 = RepositorioEspacios.findEspacios(TipoPiso.PISO_1, TipoEdificio.ADA_BYRON);
            for(int i=0; i<esps2.length; i++){
                (new Thread(new SimuladorES(esps2[i]))).start();
            }
            Espacio[] esps3 = RepositorioEspacios.findEspacios(TipoPiso.PISO_2, TipoEdificio.ADA_BYRON);
            for(int i=0; i<esps3.length; i++){
                (new Thread(new SimuladorES(esps3[i]))).start();
            }*/

            //Start Maquinas
            MaquinaExpendedora[] mes = RepositorioMaquinas.findAllMaquinas(); //solo coje ada
            HashMap<String, Integer> hm = new HashMap<>();
            hm.put("Patatas",3);
            hm.put("Chocolate",4);
            for(int i=0; i<mes.length; i++){
                mes[i].setStock(hm);
                (new Thread(new SimuladorStock(mes[i]))).start();
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
