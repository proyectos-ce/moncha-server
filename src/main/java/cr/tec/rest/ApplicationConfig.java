package cr.tec.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		packages("cr.tec.rest");
		register(JacksonFeature.class);
	}
}