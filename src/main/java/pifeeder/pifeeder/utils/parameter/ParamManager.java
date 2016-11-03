package pifeeder.pifeeder.utils.parameter;

import java.io.File;
import java.io.IOException;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pifeeder.pifeeder.utils.serializer.Serializer;


/**
 * Manager des parametres Singleton pour une serialisation des parametres sure.
 * 
 * @author Belzeb78
 *
 */
public class ParamManager {
	private final String URL_PARAMS = "./pifeeder.ini";
	/** Holder */
	private static class SingletonHolder {
		/** Instance unique non préinitialisée */
		private final static ParamManager instance = new ParamManager();
	}

	/** Point d'accès pour l'instance unique du singleton */
	public static ParamManager getInstance() {
		return SingletonHolder.instance;
	}

	private Serializer<Parameter> serializer;

	public Parameter parameter;

	private ParamManager() {
		serializer=new Serializer<Parameter>(Parameter.class);		
		try {
			LoggerFactory.getLogger(this.getClass()).info("Chargement des parametres...");
			 setParameter(serializer.readObject(new File(URL_PARAMS)));			 
		} catch (JsonParseException e) {
			LoggerFactory.getLogger(this.getClass()).warn("Erreur parseJson au chargement de PiFeeder.ini .");
			LoggerFactory.getLogger(this.getClass()).info("Parametres par defaut appliqués.");
			setParameter(new Parameter());
		} catch (JsonMappingException e) {
			LoggerFactory.getLogger(this.getClass()).warn("Erreur JsonMapping au chargement de PiFeeder.ini .");
			LoggerFactory.getLogger(this.getClass()).info("Parametres par defaut appliqués.");
			setParameter(new Parameter());
		} catch (IOException e) {
			LoggerFactory.getLogger(this.getClass()).warn("Erreur I/O au chargement de PiFeeder.ini .");
			LoggerFactory.getLogger(this.getClass()).info("Parametres par defaut appliqués.");
			setParameter(new Parameter());
		}
		LoggerFactory.getLogger(this.getClass()).info("Parametres chargés.");
	}
	
	public void saveParams(){
		try {
			LoggerFactory.getLogger(this.getClass()).info("Enregistrement des parametres...");
			serializer.writeObject(new File(URL_PARAMS), parameter);
		} catch (JsonGenerationException e) {
			LoggerFactory.getLogger(this.getClass()).warn("Erreur JsonGeneration à l'enregistrement de PiFeeder.ini .");
		} catch (JsonMappingException e) {
			LoggerFactory.getLogger(this.getClass()).warn("Erreur JsonMappingException à l'enregistrement de PiFeeder.ini .");
		} catch (IOException e) {
			e.printStackTrace();
			LoggerFactory.getLogger(this.getClass()).warn("Erreur I/O à l'enregistrement de PiFeeder.ini .");
		}
		LoggerFactory.getLogger(this.getClass()).info("Parametres enregistrés.");
	}
	
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	
	public Parameter getParameter() {
		return parameter;
	}
}
