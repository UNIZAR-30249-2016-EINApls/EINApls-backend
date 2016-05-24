package einapls.infrastructure;

import org.glassfish.grizzly.Grizzly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

//adri pasará un enlace explicando esto
//ejecutar con el terminar, con intelij pk se vuele muy loco
//para compialr gralde build y ejecutar gradle run
//wms es lo que tenemos que devolver par pitar las imagenes
//en geoson las areas de la scafeterias lo que capturan los snesores
//servico wms con las fotos d elos mpas de cada mpaa
//modelo de negocio tmb pendiente
//openstreetmap, adaptar las coordendas

@Path("hello")
public class HelloEndpoint {

    private static final Logger LOGGER = Grizzly.logger(Server.class);

    static { LOGGER.setLevel(Level.FINER);}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        LOGGER.info("GET /hello");
        return "Hello world!";
    }


}
