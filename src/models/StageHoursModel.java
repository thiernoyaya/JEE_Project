package Models;

public class StageHoursModel {
	
	/*************Membres d'instanciation******************************/
	private String nameDay;
	private String heurBeginAm;
	private String heureEndAm;
	private String heureBeginPm;
	private String heureEndPm;
	
	/*****************Constructeur *******************/
	public StageHoursModel(){
		this.nameDay = null;
		this.heurBeginAm = null;
		this.heureEndAm = null;
		this.heureBeginPm = null;
		this.heureEndPm = null;
	}
	
	public StageHoursModel(String nameDay, String heurBeginAm, String heureEndAm, String heureBeginPm, 
			String heureEndPm ){
		this.nameDay = nameDay;
		this.heurBeginAm = heurBeginAm;
		this.heureEndAm = heureEndAm;
		this.heureBeginPm = heureBeginPm;
		this.heureEndPm = heureEndPm;
	}
	
	/***********************getters****************************************/
	public String getNameDay(){ return this.nameDay; }
	public String getHeureBeginAM(){ return this.heurBeginAm; }
	public String getHeureEndAM(){ return this.heureEndAm; }
	public String getHeureBeginPM(){ return this.heureBeginPm; }
	public String getHeureEndPM(){ return this.heureEndPm; }
	
	/***********************setters****************************************/
	public void setNameDay(String value){ this.nameDay = value;}
	public void setHeureBeganAM(String value){ this.heurBeginAm = value;}
	public void setHeureEndAM(String value){ this.heureEndAm = value;}
	public void setHeureBeganPM(String value){ this.heureBeginPm = value;}
	public void setHeureEndPM(String value){ this.heureEndPm = value;}

}
