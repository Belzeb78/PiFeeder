package pifeeder.pifeeder.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.slf4j.LoggerFactory;

import pifeeder.pifeeder.webservice.RestFeed;

public class JaxRsApp extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
		LoggerFactory.getLogger(this.getClass()).info("Initializing JAX-RS application...");
        Set<Class<?>> res = new HashSet<Class<?>>();
        res.add(RestFeed.class);
        return res;
    }
    
}