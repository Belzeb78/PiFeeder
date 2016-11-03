package pifeeder.pifeeder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.LoggerFactory;

import pifeeder.pifeeder.rest.application.RestletComponent;
import pifeeder.pifeeder.utils.crontrigger.main.FeedCronTrigger;
import pifeeder.pifeeder.utils.parameter.ParamManager;

public abstract class App {

	public static void main(String[] args) {		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY dd MM à HH:mm:ss");
		LoggerFactory.getLogger(App.class).info(String.format("### Démarrage PiFeeder %s ###", LocalDateTime.now().format(dtf)));
//		ParamManager.getInstance().getParameter().setTimeToFeed("0 0/2 * * * ?");
		LoggerFactory.getLogger(App.class).info("Parametre \"TimeToFeed\": " + ParamManager.getInstance().getParameter().getTimeToFeed());
		
		//Enregistrement des paramètres
		ParamManager.getInstance().saveParams();
		FeedCronTrigger.getInstance().start(ParamManager.getInstance().getParameter().getTimeToFeed());
		
		LoggerFactory.getLogger(App.class).info("### Lancement RestLet ###");
		try {			
			new RestletComponent().start();			  
		} catch (Exception e) {
			LoggerFactory.getLogger(App.class).warn("Erreur au démarrage de RestLet");
			e.printStackTrace();
		}
	}

}
