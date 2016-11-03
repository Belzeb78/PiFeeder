
package pifeeder.pifeeder.rest.application;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.routing.Template;
import org.slf4j.LoggerFactory;

public class RestletComponent extends Component {

    public RestletComponent() {
    	
        getServers().add(Protocol.HTTP, 8000);
        //server.getContext().getParameters().set("tracing", "true");

        getClients().add(Protocol.CLAP);
        
        getDefaultHost().attachDefault(new RestletRouterApplication(getContext().createChildContext()));
        getDefaultHost().attach("/rest/",new ResletJaxRsApplication(getContext().createChildContext())).setMatchingMode(Template.MODE_STARTS_WITH);
        Engine.getInstance().getRegisteredClients().add(0, new JarClapClientHelper(null));
        
        LoggerFactory.getLogger(this.getClass()).info("Server started.");
        LoggerFactory.getLogger(this.getClass()).info("Application is now available on http://localhost");

    }
}
