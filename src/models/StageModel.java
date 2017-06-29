package Models;

import com.sun.istack.logging.Logger;

import Beans.Stage;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List; 

import DAO.AbstractDAOFactory;
import DAO.DAO_JEE;
import DAO.DAO_Stage;

public class StageModel {	
	protected Logger logger = Logger.getLogger(StageModel.class);

	/**
	 * The student 
	 */
	private SchoolStudentModel student;
	
	/**
	 * The company name
	 */
	private String entName;
	
	/**
	 * The company supervisor name
	 */
	private String entSpvName;
	
	/**
	 * The company supervisor email
	 */
	private String entSpvMail;
	
	/**
	 * The company supervisor tel
	 */
	private String entSpvTel;
	
	/**
	 * The compagny supervisor fax
	 */
	private String entSpvFax;
	
	/**
	 * The compagny country name
	 */
	private String entCountry;
	
	/**
	 * The company state name
	 */
	private String entState;
	
	/**
	 * The company zipcode
	 */
	private String entZipCode;
	
	/**
	 * The compagny city
	 */
	private String entCity;
	
	/**
	 * The company street name
	 */
	private String entStreet;
	
	/**
	 * The company street number
	 */
	private String entStreetNB;
	
	/**
	 * The company street box
	 */
	private String entStreetBox;
	
	/**
	 * The begining date of intership
	 */
	private Date dateBegin;
	
	/**
	 * The end date of intership
	 */
	private Date dateEnd;
	
	/**
	 * The title of TFE
	 */
	private String tfeTheme;
	
	/**
	 * The hours of intership
	 */
	private List<StageHoursModel> listStageHours;
	
	public StageModel() {
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
		this.listStageHours = new ArrayList<>();
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
		this.listStageHours = new ArrayList<>();
	}
	
	/**
	 * 
	 * @return the student
	 */
	public SchoolStudentModel getStudent() { 
		return this.student;
	}
	/**
	 * 
	 * @return the entreprise name
	 */
	public String getEntName() { 
		return this.entName;
	}
	
	/**
	 * 
	 * @return the supervisor name
	 */
	public String getEntSupervisorName() { 
		return this.entSpvName;
	}
	
	/**
	 * 
	 * @return the supervisor mail
	 */
	public String getEntSupervisorMail() { 
		return this.entSpvMail; 
	}
	
	/**
	 * 
	 * @return the supervisor tel
	 */
	public String getEntSupervisorTel() { 
		return this.entSpvTel;
	}
	
	/**
	 * 
	 * @return the supervisor fax
	 */
	public String getEntSupervisorFax() { 
		return this.entSpvFax; 
	}
	
	/**
	 * 
	 * @return the company country
	 */
	public String getEntCountry() { 
		return this.entCountry; 
	}
	
	/**
	 * 
	 * @return the compagny state
	 */
	public String getEntState() { 
		return this.entState; 
	}
	
	/**
	 * 
	 * @return the compagny zipcode
	 */
	public String getEntZipCode() { 
		return this.entZipCode;
	}
	
	/**
	 * 
	 * @return the company city
	 */
	public String getEntCity() { 
		return this.entCity;
	}
	
	/**
	 * 
	 * @return the compagny street 
	 */
	public String getEntStreet() { 
		return this.entStreet; 
	}
	
	/**
	 * 
	 * @return The company street number
	 */
	public String getEntStreetNB() {
		return this.entStreetNB; 
	}
	
	/**
	 * 
	 * @return the compagny street box
	 */
	public String getEntStreetBox() { 
		return this.entStreetBox;
	}
	
	/**
	 * 
	 * @return the begin date of stage
	 */
	public Date getDateBegin() { 
		return this.dateBegin;
	}
	
	/**
	 * 
	 * @return the end date of stage
	 */
	public Date getDateEnd() { 
		return this.dateEnd; 
	}
	
	/**
	 * 
	 * @return the title of memory
	 */
	public String getTFETheme() { 
		return this.tfeTheme; 
	}
	/**
	 * 
	 * @return the list of stage hours
	 */
	public List<StageHoursModel> getListStageHours() { 
		return this.listStageHours;
	}
	
	/**
	 * 
	 * @param value: set the value of student
	 */
	public void setStudent(SchoolStudentModel value) { 
		this.student = value;
	}
	
	/**
	 * 
	 * @param value: set the value of company name
	 */
	public void setEntName(String value) {
		this.entName = value; 
	}
	
	/**
	 * 
	 * @param value: the value of supervisor name
	 */
	public void setEntSupervisorName(String value) { 
		this.entSpvName = value;
	}
	
	/**
	 * 
	 * @param value: the value of the supervisor mail
	 */
	public void setEntSupervisorMail(String value) { 
		this.entSpvMail = value; 
	}
	
	/**
	 * 
	 * @param value: The value of superversior tel
	 */
	public void setEntSupervisorTel(String value) { 
		this.entSpvTel = value; 
	}
	
	/**
	 * 
	 * @param value: the value of fax
	 */
	public void setEntSupervisorFax(String value) {
		this.entSpvFax = value; 
	}
	
	/**
	 * 
	 * @param value: the value of country name
	 */
	public void setEntCountry(String value) { 
		this.entCountry = value;
	}
	
	/**
	 * 
	 * @param value: the value of state name
	 */
	public void setEntState(String value) { 
		this.entState = value;
	}
	
	/**
	 * 
	 * @param value: the value of zipcode
	 */
	public void setEntZipCode(String value) {
		this.entZipCode = value;
	}
	
	/**
	 * 
	 * @param value: the value of city
	 */
	public void setEntCity(String value) { 
		this.entCity = value; 
	}
	
	/**
	 * 
	 * @param value: set the street name
	 */
	public void setEntStreet(String value) { 
		this.entStreet = value;
	}
	
	/**
	 * 
	 * @param value: set street number
	 */
	public void setEntStreetNB(String value) { 
		this.entStreetNB = value;
	}
	
	/**
	 * 
	 * @param value: set the street box
	 */
	public void setEntStreetBox(String value) { 
		this.entStreetBox = value;
	}
	
	/**
	 * 
	 * @param value: set begining date
	 */
	public void setDateBegin(Date value) { 
		this.dateBegin = value;
	}
	
	/**
	 * 
	 * @param value: set end date
	 */
	public void setDateEnd(Date value) { 
		this.dateEnd = value;
	}
	
	/**
	 * 
	 * @param value: set the memory title
	 */
	public void setTFETheme(String value) { 
		this.tfeTheme = value; 
	}
	
	
	/**
	 * This method allows to add the stage hours into the list
	 * 
	 * @param inStageHours: the stage hours to process
	 * @return true if the operation successfull neither false
	 */
	public boolean addStageHour(StageHoursModel inStageHours) {
		if (!this.listStageHours.contains(inStageHours)) {
			this.listStageHours.add(inStageHours);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method allows to remove the hours into list
	 * 
	 * @param inStageHours: the hours to be process
	 */
	public void removeStageHour (StageHoursModel inStageHours) {
		if (this.listStageHours.contains(inStageHours))
			this.listStageHours.remove(inStageHours);
	}
	
	
	/**
	 * This method enable to create a intership
	 * 
	 * @param inStage: The intership to be process
	 * @return: True if operation successfull neither false
	 * @throws Exception
	 */
	public boolean createStage(StageModel inStage) throws Exception{
		logger.info("Entering the method: createStage(StageModel)");
		
		if(inStage == null){
			logger.info("inStage must be initialized");
			logger.info("Exting the method: createStage(StageModel)");
			throw new Exception("The training must be initialized");			
		}
		
		logger.info("Exiting the method: createStage(StageModel)");
		return addStage(inStage);
	}
	
	/**
	 * This method give us the informations about the student intership
	 * 
	 * @param inSchoolStudent: The student to be process
	 * @return the intership of the student
	 * @throws Exception
	 */
	public Stage studentTraining(SchoolStudentModel inSchoolStudent) throws Exception{
		logger.info("Entering the method: studentTraining(SchoolStudentModel)");
		
		if(inSchoolStudent == null){
			logger.info("inSchoolStudent must be initialized");
			logger.info("Exting the method: studentTraining(SchoolStudentModel)");
			throw new Exception("The student must be initialized");			
		}
		
		logger.info("Exiting the method: studentTraining(SchoolStudentModel)");
		return studentIntership(inSchoolStudent);
	}
	
	
	/**
	 * This method allow add the training into the database
	 * 
	 * @param inStage: the training to be proces
	 * @return : True if the training add successful neither false 
	 * @throws Exception
	 */
	private boolean addStage(StageModel inStage) throws Exception{	
		logger.info("Entering the method: addStage(StageModel)");
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
		DAO_JEE<StageModel> StageDAO = adf.getDAO_Stage() ;
		
		logger.info("Exiting the method: addStage(StageModel)");
		return ((DAO_Stage) StageDAO).create(inStage);
	}
	
	/**
	 * This method retrieve the intership information from database
	 * 
	 * @param inSchoolStudent: The student to be process
	 * @return a Stage if operation successfull neither null
	 * @throws Exception
	 */
	private Stage studentIntership(SchoolStudentModel inSchoolStudent) throws Exception{	
		logger.info("Entering the method: studentIntership(SchoolStudentModel)");
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
		DAO_JEE<StageModel> StageDAO = adf.getDAO_Stage() ;
		
		logger.info("Exiting the method: studentIntership(SchoolStudentModel)");
		return ((DAO_Stage) StageDAO).findStudentStage(inSchoolStudent);
	}
	
}