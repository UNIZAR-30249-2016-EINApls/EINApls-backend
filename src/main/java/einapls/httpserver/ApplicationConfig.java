package einapls.httpserver;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(HelloEndpoint.class);
        register(CafeteriaEndpoint.class);
        register(LaboratorioEndpoint.class);
        register(SalaEstudioEndpint.class);
    }

}
