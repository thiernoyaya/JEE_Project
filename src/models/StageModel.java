package Models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import DB.DB_Stage;

public class StageModel {
	
	/*************Membres d'instanciation******************************/
	private SchoolStudentModel student;
	private String entName;
	private String entSpvName;
	private String entSpvMail;
	private String entSpvTel;
	private String entSpvFax;
	private String entCountry;
	private String entState;
	private String entZipCode;
	private String entCity;
	private String entStreet;
	private String entStreetNB;
	private String entStreetBox;
	private Date dateBegin;
	private Date dateEnd;
	private String tfeTheme;
	private Set<StageHoursModel> listStageHours;
	
	/************** constructeur **********************************/
	public StageModel() {
		this.student = null;
		this.entName = null;
		this.entSpvName = null;
		this.entSpvMail = null;
		this.entSpvTel = null;
		this.entSpvFax = null;
		this.entCountry = null;
		this.entState = null;
		this.entZipCode = null;
		this.entCity = null;
		this.entStreet = null;
		this.entStreetNB = null;
		this.entStreetBox = null;
		this.dateBegin = null;
		this.dateEnd = null;
		this.tfeTheme = null;
		this.listStageHours = null;
	}
	
	public StageModel(SchoolStudentModel student, String entName, String entSpvName, String entSpvMail,
			String entSpvTel, String entSpvFax, String entCountry, String entState, String entZipCode,
			String entCity, String entStreet, String entStreetNB, String entStreetBox, Date dateBegin, 
			Date dateEnd, String tfeTheme) {
		this.student = student;
		this.entName = entName;
		this.entSpvName = entSpvName;
		this.entSpvMail = entSpvMail;
		this.entSpvTel = entSpvTel;
		this.entSpvFax = entSpvFax;
		this.entCountry = entCountry;
		this.entState = entState;
		this.entZipCode = entZipCode;
		this.entCity = entCity;
		this.entStreet = entStreet;
		this.entStreetNB = entStreetNB;
		this.entStreetBox = entStreetBox;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.tfeTheme = tfeTheme;
		this.listStageHours = new HashSet<>();
	}
	
	public StageModel(SchoolStudentModel student, String entName, String entSpvName, String entSpvMail,
			String entSpvTel, String entCountry, String entZipCode,
			String entCity, String entStreet, String entStreetNB, Date dateBegin, 
			Date dateEnd, String tfeTheme) {
		this.student = student;
		this.entName = entName;
		this.entSpvName = entSpvName;
		this.entSpvMail = entSpvMail;
		this.entSpvTel = entSpvTel;
		this.entCountry = entCountry;
		this.entZipCode = entZipCode;
		this.entCity = entCity;
		this.entStreet = entStreet;
		this.entStreetNB = entStreetNB;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.tfeTheme = tfeTheme;
		this.listStageHours = new HashSet<>();
	}
	
	/***********************getters****************************************/
	public SchoolStudentModel getStudent() { return this.student; }
	public String getEntName() { return this.entName; }
	public String getEntSupervisorName() { return this.entSpvName; }
	public String getEntSupervisorMail() { return this.entSpvMail; }
	public String getEntSupervisorTel() { return this.entSpvTel; }
	public String getEntSupervisorFax() { return this.entSpvFax; }
	public String getEntCountry() { return this.entCountry; }
	public String getEntState() { return this.entState; }
	public String getEntZipCode() { return this.entZipCode; }
	public String getEntCity() { return this.entCity; }
	public String getEntStreet() { return this.entStreet; }
	public String getEntStreetNB() { return this.entStreetNB; }
	public String getEntStreetBox() { return this.entStreetBox; }
	public Date getDateBegin() { return this.dateBegin; }
	public Date getDateEnd() { return this.dateEnd; }
	public String getTFETheme() { return this.tfeTheme; }
	public Set<StageHoursModel> getListStageHours() { return this.listStageHours; }
	
	/***********************setters****************************************/
	public void setStudent(SchoolStudentModel value) { this.student = value; }
	public void setEntName(String value) { this.entName = value; }
	public void setEntSupervisorName(String value) { this.entSpvName = value; }
	public void setEntSupervisorMail(String value) { this.entSpvMail = value; }
	public void setEntSupervisorTel(String value) { this.entSpvTel = value; }
	public void setEntSupervisorFax(String value) { this.entSpvFax = value; }
	public void setEntCountry(String value) { this.entCountry = value; }
	public void setEntState(String value) { this.entState = value; }
	public void setEntZipCode(String value) { this.entZipCode = value; }
	public void setEntCity(String value) { this.entCity = value; }
	public void setEntStreet(String value) { this.entStreet = value; }
	public void setEntStreetNB(String value) { this.entStreetNB = value; }
	public void setEntStreetBox(String value) { this.entStreetBox = value; }
	public void setDateBegin(Date value) { this.dateBegin = value; }
	public void setDateEnd(Date value) { this.dateEnd = value; }
	public void setTFETheme(String value) { this.tfeTheme = value; }
	
	/***********************méthodes publiques*****************************/
	public boolean addStageHour(StageHoursModel sh) {
		if (!this.listStageHours.contains(sh)) {
			this.listStageHours.add(sh);
			return true;
		} else {
			return false;
		}
	}
	
	public void removeStageHour (StageHoursModel sh) {
		if (this.listStageHours.contains(sh))
			this.listStageHours.remove(sh);
	}
	
	/********* insertion d'un stage
	 * @throws Exception ******************************/
	public static boolean createStage(StageModel obj) throws Exception{
		return DB_Stage.createStage(obj);
	}
	
	public StageModel studentTraining(SchoolStudentModel ss) throws Exception{
		return DB_Stage.studentStage(ss);
	}
	
	
	
	
	
	
}