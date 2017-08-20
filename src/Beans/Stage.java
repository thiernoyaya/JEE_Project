package Beans;

import java.sql.Date;
import java.util.List;

import Models.SchoolStudentModel;
import Models.StageHoursModel;

public class Stage {
	/**
	 * The school student
	 */
	private SchoolStudentModel student;
	
	/**
	 * The name of corporate
	 */
	private String entName;
	
	/**
	 * The name of supervisor 
	 */
	private String entSpvName;
	
	/**
	 * The mail of supervisor
	 */
	private String entSpvMail;
	
	/**
	 * The tel of supervisor
	 */
	private String entSpvTel;
	
	/**
	 * The fax of supervisor
	 */
	private String entSpvFax;
	
	/**
	 * the country of corporate
	 */
	private String entCountry;
	
	/**
	 *  the name of state
	 */
	private String entState;
	
	/**
	 * The zip code
	 */
	private String entZipCode;
	
	/**
	 * The name of city
	 */
	private String entCity;
	
	/**
	 * the name of street
	 */
	private String entStreet;
	
	/**
	 * The number of street
	 */
	private String entStreetNB;
	
	/**
	 * The number of box
	 */
	private String entStreetBox;
	
	/**
	 * The date of begining  stage 
	 */
	private Date dateBegin;
	
	/**
	 * The date of end stage
	 */
	private Date dateEnd;
	
	/**
	 * The title of TFE
	 */
	private String tfeTheme;
	
	/**
	 * The list of stage hours
	 */
	private List<StageHoursModel> listStageHours;

	public SchoolStudentModel getStudent() {
		return student;
	}

	public void setStudent(SchoolStudentModel student) {
		this.student = student;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getEntSpvName() {
		return entSpvName;
	}

	public void setEntSpvName(String entSpvName) {
		this.entSpvName = entSpvName;
	}

	public String getEntSpvMail() {
		return entSpvMail;
	}

	public void setEntSpvMail(String entSpvMail) {
		this.entSpvMail = entSpvMail;
	}

	public String getEntSpvTel() {
		return entSpvTel;
	}

	public void setEntSpvTel(String entSpvTel) {
		this.entSpvTel = entSpvTel;
	}

	public String getEntSpvFax() {
		return entSpvFax;
	}

	public void setEntSpvFax(String entSpvFax) {
		this.entSpvFax = entSpvFax;
	}

	public String getEntCountry() {
		return entCountry;
	}

	public void setEntCountry(String entCountry) {
		this.entCountry = entCountry;
	}

	public String getEntState() {
		return entState;
	}

	public void setEntState(String entState) {
		this.entState = entState;
	}

	public String getEntZipCode() {
		return entZipCode;
	}

	public void setEntZipCode(String entZipCode) {
		this.entZipCode = entZipCode;
	}

	public String getEntCity() {
		return entCity;
	}

	public void setEntCity(String entCity) {
		this.entCity = entCity;
	}

	public String getEntStreet() {
		return entStreet;
	}

	public void setEntStreet(String entStreet) {
		this.entStreet = entStreet;
	}

	public String getEntStreetNB() {
		return entStreetNB;
	}

	public void setEntStreetNB(String entStreetNB) {
		this.entStreetNB = entStreetNB;
	}

	public String getEntStreetBox() {
		return entStreetBox;
	}

	public void setEntStreetBox(String entStreetBox) {
		this.entStreetBox = entStreetBox;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getTfeTheme() {
		return tfeTheme;
	}

	public void setTfeTheme(String tfeTheme) {
		this.tfeTheme = tfeTheme;
	}

	public List<StageHoursModel> getListStageHours() {
		return listStageHours;
	}

	public void setListStageHours(List<StageHoursModel> listStageHours) {
		this.listStageHours = listStageHours;
	}

}
