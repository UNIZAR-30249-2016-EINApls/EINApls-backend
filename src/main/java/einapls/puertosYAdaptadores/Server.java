package einapls.puertosYAdaptadores;

import org.glassfish.grizzly.Grizzly;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    private static HttpServer server;
//devolveremos objetos geojson, que los tenemos que generar nosotros a manos, y hayuna ibreria para trabajr con json, ya esta importada en el gradle



    // Statically set logger level
    static { LOGGER.setLevel(Level.FINER); }

    // Start server if not started yet
    public static void startServer() throws IOException {
        if (server == null) {
            LOGGER.info("Launching server");
            URI uri = UriBuilder.fromUri("http://localhost/")
                    .port(8888).build();
            server = GrizzlyHttpServerFactory
                    .createHttpServer(uri, new ApplicationConfig());
            server.start();
            LOGGER.info("Server listening on port 8888");
        }
    }

    // Stop server
    public static void stopServer() {
        if (server != null) server.shutdownNow();
    }
}
