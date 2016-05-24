package einapls;

import einapls.infrastructure.Server;
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
