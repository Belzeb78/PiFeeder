package pifeeder.pifeeder.rest.application;

import org.restlet.Context;
import org.restlet.ext.jaxrs.JaxRsApplication;

public class ResletJaxRsApplication extends JaxRsApplication {

	public ResletJaxRsApplication(Context context) {
			super(context);		
			add(new JaxRsApp());
			setName("PiFeeder");
			setDescription("Gestion du PiFeeder");
			setOwner("Belzeb78");
			setAuthor("Belz.VgS");			
		}
 
	
	
}
