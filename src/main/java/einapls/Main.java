package einapls;

import einapls.application.SimuladorES;
import einapls.domain.Espacio;
import einapls.domain.RepositorioEspacios;
import einapls.domain.enumerations.TipoEdificio;
import einapls.domain.enumerations.TipoPiso;
import einapls.puertosYAdaptadores.Server;
import org.glassfish.grizzly.Grizzly;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Grizzly.logger(Main.class);

    public static void main(String [] args) {
        LOGGER.setLevel(Level.FINER);
        try (Scanner scan = new Scanner(System.in)){
            Server.startServer();
            //Start Espacios
            Espacio[] esps = RepositorioEspacios.findEspacios(TipoPiso.PISO_0, TipoEdificio.ADA_BYRON);
            (new Thread(new SimuladorES(esps[0]))).start();

            //TODO Start Maquinas


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
}
