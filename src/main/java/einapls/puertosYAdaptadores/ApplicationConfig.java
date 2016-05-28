package einapls.puertosYAdaptadores;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(CORSFilter.class);
        register(EspacioEndpoint.class);
        register(EspaciosEndpoint.class);
        register(IncidenciaEndpoint.class);
        register(IncidenciasEndpoint.class);
        register(MaquinaEndpoint.class);
        register(MaquinasEndpoint.class);
    }

    //para cada de clase de java que teng aun end point hay que declararla en este constructor
}
