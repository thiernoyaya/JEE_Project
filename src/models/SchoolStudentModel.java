package Models;


import java.util.Set;

import com.sun.istack.logging.Logger;

import Beans.Stage;
import DAO.AbstractDAOFactory;
import DAO.DAO_JEE;
import DAO.DAO_SchoolStudent;

public class SchoolStudentModel extends UserModel{
	
	/**
	 * Setting up logger
	 */
	protected Logger logger = Logger.getLogger(UserModel.class);
	
	/**
	 * The member of coordinator
	 */
	private SchoolMemberModel coordinator;
	
	/**
	 * The member of supervisor
	 */
	private SchoolMemberModel supervisor;
	
	/**
	 * The stage 
	 */
	private StageModel stage = new StageModel();
	
	/**
	 * the national number
	 */
	private String niss;
	
	/**
	 * The zipcode
	 */
	private String zipCode;
	
	/**
	 * The name of city
	 */
	private String city;
	
	/**
	 * The street name
	 */
	private String street;
	
	/**
	 * The street number
	 */
	private String streetNB;
	
	/**
	 * The street box
	 */
	private String streetBox;
	
	/**
	 * The tel of student
	 */
	private String tel;
	
	/**
	 * The section of student
	 */
	private String section;
	
	/**
	 * The category of student
	 */
	private String category;
	
	/**
	 * The school of student
	 */
	private String establishment;
	
	/**
	 * Constructor
	 */
	public SchoolStudentModel(){
		super();
		this.coordinator = null;
		this.supervisor = null;
		this.niss = null;
		this.zipCode = null;
		this.city = null;
		this.street = null;
		this.streetNB = null;
		this.streetBox = null;
		this.tel = null;
		this.section = null;
		this.category = null;
		this.establishment = null;
	}
	
	public SchoolStudentModel(String usn, String pwd, String fname, String lname, String mail, boolean factive,
			SchoolMemberModel coordinator, SchoolMemberModel supervisor, String niss, String zipCode, String city,
			String street, String streetNB, String streetBox, String tel, String section, String category,
			String establishment) {
		super(usn, pwd, fname, lname, mail, factive);
		this.coordinator = coordinator;
		this.supervisor = supervisor;
		this.niss = niss;
		this.zipCode = zipCode;
		this.city = city;
		this.street = street;
		this.streetNB = streetNB;
		this.streetBox = streetBox;
		this.tel = tel;
		this.section = section;
		this.category = category;
		this.establishment = establishment;
	}
	
	public SchoolStudentModel( String fname, String lname, String mail, boolean factive,
			SchoolMemberModel coordinator, SchoolMemberModel supervisor, String niss, String zipCode, String city,
			String street, String streetNB,  String tel, String section, String category,
			String establishment) {
		super( fname, lname, mail, factive);
		this.coordinator = coordinator;
		this.supervisor = supervisor;
		this.niss = niss;
		this.zipCode = zipCode;
		this.city = city;
		this.street = street;
		this.streetNB = streetNB;
		this.tel = tel;
		this.section = section;
		this.category = category;
		this.establishment = establishment;
	}
	
	
	public SchoolStudentModel(String usn, String pwd,  boolean factive) {
		super(usn, pwd,factive);
	}
	
	/**
	 * 
	 * @return The coordinator of student
	 */
	public SchoolMemberModel getCoordinator() { 
		return this.coordinator;
	}
	
	/**
	 * 
	 * @return The supervisor of student 
	 */
	public SchoolMemberModel getSupervisor() { 
		return this.supervisor; 
	}
	
	/**
	 * 
	 * @return The nationnal number of student
	 */
	public String getNISS() { 
		return this.niss;
	}
	
	/**
	 * 
	 * @return The zipcode
	 */
	public String getZipCode() { 
		return this.zipCode; 
	}
	
	/**
	 * 
	 * @return The name of city 
	 */
	public String getCity() { 
		return this.city; 
	}
	
	/**
	 * 
	 * @return The name of street 
	 */
	public String getStreet() { 
		return this.street; 
	}
	
	/**
	 * 
	 * @return The street number
	 */
	public String getStreetNB() {
		return this.streetNB; 
	}
	
	/**
	 * 
	 * @return The street box
	 */
	public String getStreetBox() { 
		return this.streetBox; 
	}
	
	/**
	 * 
	 * @return The tel
	 */
	public String getTel() { 
		return this.tel; 
	}
	
	/**
	 * 
	 * @return The section of student
	 */
	public String getSection() { 
		return this.section;
	}
	
	/**
	 * 
	 * @return The category 
	 */
	public String getCategory() { 
		return this.category; 
	}
	
	/**
	 * 
	 * @return The establishment
	 */
	public String getEstablishment() { 
		return this.establishment; 
	}
	
	/**
	 * 
	 * @return The student intership
	 */
	public StageModel getStage(){ 
		return this.stage; 
	}
	
	/**
	 * 
	 * @param value: set a coordinator
	 */
	public void setCoordinator(SchoolMemberModel value) {
		this.coordinator = value; 
	}
	
	/**
	 * 
	 * @param value: set a supervisor
	 */
	public void setSupervisor(SchoolMemberModel value) { 
		this.supervisor = value; 
	}
	
	/**
	 * 
	 * @param value: set a niss
	 */
	public void setNISS(String value) { 
		this.niss = value; 
	}
	
	/**
	 * 
	 * @param value: set a zipcode
	 */
	public void setZipCode(String value) { 
		this.zipCode = value; 
	}
	
	/**
	 * 
	 * @param value: set the name of city
	 */
	public void setCity(String value) { 
		this.city = value; 
	}
	
	/**
	 * 
	 * @param value: set the street name
	 */
	public void setStreet(String value) {
		this.street = value; 
	}
	
	/**
	 * 
	 * @param value: set the street number
	 */
	public void setStreetNB(String value) { 
		this.streetNB = value; 
	}
	
	/**
	 * 
	 * @param value: set the street box value
	 */
	public void setStreetBox(String value) { 
		this.streetBox = value; 
	}
	
	/**
	 * 
	 * @param value: set the value of tel
	 */
	public void setTel(String value) { 
		this.tel = value; 
	}
	
	/**
	 * 
	 * @param value: set the value of the section
	 */
	public void setSection(String value) { 
		this.section = value; 
	}
	
	/**
	 * 
	 * @param value: set the value of category
	 */
	public void setCategory(String value) { 
		this.category = value; 
	}
	
	/**
	 * 
	 * @param value: set the value of establishment
	 */
	public void setEstablishment(String value) { 
		this.establishment = value; 
	}
	
	
	/**
	 * This method allows to create a intership
	 * 
	 * @param inStudent: The student to be process
	 * @return True if the operation successfull neither false
	 * @throws Exception
	 */
	public boolean createStage(SchoolStudentModel inStudent) throws Exception{
		logger.info("Entering the method: createStage(SchoolStudentModel)");
		if(inStudent == null){
			logger.info("inStudent must be initialized");
			logger.info("Exiting the method: createStage(SchoolStudentModel)");
			throw new Exception("Please fill in the empty fields!");
		}
		
		if(inStudent.getSupervisor() != null && inStudent.getCoordinator() != null && !inStudent.getMail().isEmpty() &&  !inStudent.getTel().isEmpty() && !inStudent.getStreet().isEmpty() && !inStudent.getCity().isEmpty()){
			logger.info("Exiting the method: createStage(SchoolStudentModel)");
			return addStage(inStudent);
		}
		else{
			logger.info("Exiting the method: createStage(SchoolStudentModel)");
			throw new Exception("You already have an internship or please fill in the blank fields");
		}
	}
	
	/**
	 * This method enable to get all student 
	 * 
	 * @return A list of student
	 * @throws Exception
	 */
	public static Set<SchoolStudentModel> listOfALLStudent() throws Exception{
		return allStudent();
	}
	
	/**
	 * This method allows to get a specific student whose name passed parameter
	 * 
	 * @param inUsn: The student name 
	 * @return The student or null if he doesn't find
	 * @throws Exception
	 */
	public  SchoolStudentModel getStudent(String inUsn) throws Exception{
		logger.info("Entering the method: getStudent(String)");
		
		if(inUsn.equals("")){
			logger.info("inUsn must be initialized");
			logger.info("Exiting the method: getStudent(String)");
			throw new Exception("you must fix the value of inUsn");
		}
		logger.info("Exiting the method: getStudent(String)");
		return  createStudent(inUsn);
	}
	
  
	/**
	 * This method allows to get a student intership
	 * 
	 * @param inStudent: The student to be process
	 * @return The intership of student or null if he doesn't find
	 * @throws Exception
	 */
	public  Stage TrainingOfStudent(SchoolStudentModel inStudent) throws Exception{
		logger.info("Entering the method: TrainingOfStudent(SchoolStudentModel)");
		
		if(inStudent == null){
			logger.info("inStudent must be initialized");
			logger.info("Exiting the method: TrainingOfStudent(SchoolStudentModel)");
			throw new Exception("please fi the value of student");
		}
		
		logger.info("Exiting the method: TrainingOfStudent(SchoolStudentModel)");
		return    stage.studentTraining(inStudent);
	}
	
	
	
	/**
	 * This method return all student from database
	 */
	private static Set<SchoolStudentModel> allStudent() throws Exception{
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudentModel> StudentDAO = adf.getDAO_SchoolStudent() ;
			return ((DAO_SchoolStudent) StudentDAO).findAllStudent();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * This method the stage into database
	 * 
	 * @param obj: The intership to be process
	 * @return True if the operation successfull neither false
	 * @throws Exception
	 */
	private boolean addStage(SchoolStudentModel obj) throws Exception{
	    AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
		DAO_JEE<SchoolStudentModel> StudentDAO = adf.getDAO_SchoolStudent() ;
		return ((DAO_SchoolStudent) StudentDAO).update(obj);		
	}
	
	
	/**
	 * This method allows to find a student from database
	 * 
	 * @param usn: The student to be process
	 * @return The student or null
	 * @throws Exception
	 */
	private  SchoolStudentModel createStudent(String usn) throws Exception{
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudentModel> StudentDAO = adf.getDAO_SchoolStudent() ;
			return ((DAO_SchoolStudent) StudentDAO).find(usn);
		} catch (Exception ex) {
			throw ex;
		}
	}
}







