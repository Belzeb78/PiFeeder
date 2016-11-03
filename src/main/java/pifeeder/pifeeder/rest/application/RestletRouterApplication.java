package pifeeder.pifeeder.rest.application;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class RestletRouterApplication extends Application {

	public RestletRouterApplication(Context context) {
//			super(context);	
			setName("PiFeeder");
			setDescription("Gestion du PiFeeder");
			setOwner("Belzeb78");
			setAuthor("Belz.VgS");			
			
		}

	@Override
	public Restlet createInboundRoot() {		
		Directory directory = new Directory(getContext(), "clap://class/static/");		
		directory.setDeeplyAccessible(true);
		directory.setIndexName("index.html");
		
		Router router = new Router(getContext());
//		Redirector redirector = new Redirector(getContext(), "/index.html/", Redirector.MODE_CLIENT_PERMANENT);
//        TemplateRoute route = router.attach("/",redirector);
//        route.setMatchingMode(Template.MODE_EQUALS);
		
		router.attach("/web",directory);
		
		return router;	
	}
	
	 
	
	
}
