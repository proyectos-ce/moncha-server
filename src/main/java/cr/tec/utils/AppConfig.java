package cr.tec.utils;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class AppConfig extends ResourceConfig {
	public AppConfig() {
		packages("cr.tec.rest");
		register(JacksonFeature.class);
	}


}