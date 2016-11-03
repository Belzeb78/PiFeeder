package pifeeder.pifeeder.utils.parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Parameter{
	
	@JsonIgnore
	public final String DEFAULTTIMETOFEED = "0 0 19 * * ?";
	@JsonIgnore
	public final int DEFAULTNBREPETITIONS = 3;
	@JsonIgnore
	public final int DEFAULTTEMPSPAUSE = 250;
	@JsonIgnore
	public final int DEFAULTANGLEDEBUT = 75;
	@JsonIgnore
	public final int DEFAULTANGLEFIN = 195;
	
	public Parameter() {
	}
	
	/**
	 * Pattern du timer
	 */	
	private String timeToFeed = DEFAULTTIMETOFEED;
	
	private int nbRepetition = DEFAULTNBREPETITIONS;	
	
	private int tempsPause = DEFAULTTEMPSPAUSE;
	
	private int angleDebut = DEFAULTANGLEDEBUT;
	
	private int angleFin = DEFAULTANGLEFIN;
	
	public String getTimeToFeed() {
		return timeToFeed;
	}
	
	public void setTimeToFeed(String timeToFeed) {
		this.timeToFeed = timeToFeed;
	}

	public int getNbRepetition() {
		return nbRepetition;
	}

	public void setNbRepetition(int nbRepetition) {
		this.nbRepetition = nbRepetition;
	}

	public int getTempsPause() {
		return tempsPause;
	}

	public void setTempsPause(int tempsPause) {
		this.tempsPause = tempsPause;
	}

	public int getAngleDebut() {
		return angleDebut;
	}

	public void setAngleDebut(int angleDebut) {
		this.angleDebut = angleDebut;
	}

	public int getAngleFin() {
		return angleFin;
	}

	public void setAngleFin(int angleFin) {
		this.angleFin = angleFin;
	}
	
	
	
}
