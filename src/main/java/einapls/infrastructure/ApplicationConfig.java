package einapls.infrastructure;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(HelloEndpoint.class);
        register(CafeteriaEndpoint.class);
        register(LaboratorioEndpoint.class);
        register(SalaEstudioEndpint.class);
    }

    //para cada de clase de java que teng aun end point hay que declararla en este constructor
}
