package pifeeder.pifeeder.webservice.dto;

public class DtoFeeding {
	
	private int nbRepetitions;
	
	private int tempsPause;
	
	private int angleMinimum;
	
	private int angleMaximum;
	
	public DtoFeeding() {
	}

	public int getNbRepetitions() {
		return nbRepetitions;
	}

	public void setNbRepetitions(int nbRepetitions) {
		this.nbRepetitions = nbRepetitions;
	}

	public int getTempsPause() {
		return tempsPause;
	}

	public void setTempsPause(int tempsPause) {
		this.tempsPause = tempsPause;
	}

	public int getAngleMinimum() {
		return angleMinimum;
	}

	public void setAngleMinimum(int angleMinimum) {
		this.angleMinimum = angleMinimum;
	}

	public int getAngleMaximum() {
		return angleMaximum;
	}

	public void setAngleMaximum(int angleMaximum) {
		this.angleMaximum = angleMaximum;
	}
	
	
}
