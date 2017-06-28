package Models;

import com.sun.istack.logging.Logger;
import DAO.AbstractDAOFactory;
import DAO.DAO_JEE;
import DAO.DAO_SchoolMember;
import DAO.DAO_SchoolStudent;

public class UserModel {
	
	/**
	 * Setting up logger
	 */
	protected Logger logger = Logger.getLogger(UserModel.class);
	
	/**
	 * The User login
	 */
	private String usn;
	
	/**
	 * The user 
	 */
	
	/**
	 * The user password
	 */
	private String pwd;
	
	/**
	 * the status of the user
	 */
	private boolean factive;
	
	/**
	 * The user first name
	 */
	private String f_name;
	
	/**
	 * The user last name
	 */
	private String l_name;
	
	/**
	 * The user email
	*/
	private String mail;
		
	 
	public  UserModel(){
		this.usn = null;
		this.pwd = null;
		this.factive = false;
		this.f_name = null;
		this.l_name = null;
		this.mail = null;
	}
	
	public UserModel(String usn, String pwd, String fName, String lName, String mail, boolean flag_ac){
		this.usn = usn;
		this.pwd  = pwd;
		this.factive = flag_ac;
		this.f_name = fName;
		this.l_name = lName;
		this.mail = mail;
	}
	public UserModel( String fName, String lName, String mail, boolean flag_ac){
		this.factive = flag_ac;
		this.f_name = fName;
		this.l_name = lName;
		this.mail = mail;
	}

	public UserModel(String usn2, String pwd2, boolean factive2) {
		usn = usn2;
		pwd = pwd2;
		factive = factive2;
	}

	/**
	 * 
	 * @return the user login
	 */
	public String getUsn() { 
		return this.usn;
	}
	
	/**
	 * 
	 * @return The user password
	 */
	public String getPwd() { 
		return this.pwd; 
	}
	
	/***
	 * 
	 * @return The status of the user
	 */
	public boolean getFactive() { 
		return this.factive;
	}
	
	/**
	 * 
	 * @return the user first name
	 */
	public String getFirstName() { 
		return this.f_name; 
	}
	
	/**
	 * 
	 * @return The user last name
	 */
	public String getLastName() {
		return this.l_name;
	}
	
	/**
	 * 
	 * @return the user email
	 */
	public String getMail(){
		return this.mail; 
	}
	
	/**
	 * 
	 * @param value: the value to set the login
	 */
 	public void setUsn(String value) { 
 		this.usn = value; 
 	}
 	
 	/**
 	 * 
 	 * @param value: The value to set password
 	 */
	public void setPwd(String value) { 
		this.pwd = value;
	}
	
	/**
	 * 
	 * @param value: The value to set factive
	 */
	public void setFactive(boolean value) {
		this.factive = value; 
	}	
	
	/**
	 * 
	 * @param value: The value to set first name
	 */
	public void setFirstName(String value) { 
		this.f_name = value; 
	}
	
	/**
	 * 
	 * @param value: The value to set last name
	 */
	public void setLastName(String value) { 
		this.l_name = value;
	}
	
	/**
	 * 
	 * @param value: The value to set email
	 */
	public void setMail(String value) { 
		this.mail = value;
	}
	
	
	/**
	 * This metod allow to user authentification before he use the application
	 * 
	 * @param inUsn: The user login
	 * @param inPwd: The user password
	 * @return: The object that will be a student or school member
	 * @throws Exception
	 */
	public Object login(String inUsn, String inPwd) throws Exception{
		logger.info("Entring the method: login(String)");
		
		if(inUsn.isEmpty() || inPwd.isEmpty()){
			logger.info("inUsn or inPwd must be initialized");
			throw new Exception("Please fill in the blank fields!");			
		}
		
		try {
			if(checkConnexion(inUsn, inPwd)){
			   SchoolStudentModel schoolStudent = createStudent(inUsn);
			   logger.info("Exiting the method: login(String)");
			   return schoolStudent;
		    }
		    else{			   
			   if(connexionMember(inUsn, inPwd)){				   
				   SchoolMemberModel schoolMember = findMember(inUsn);
				   logger.info("Exiting the method: login(String)");
				   return schoolMember;
			   }
			   else
				   logger.info("Exiting the method: login(String)");
				   throw new Exception("The user name or password doesn't correct: please try again!"); 
		   }				
		} 
		catch (Exception ex) {
			logger.info("Exiting the method: login(String)");
			throw ex;
		}
	}
	
	/**
	 * This function enable to check if the student can connecting into the application
	 * it's allow to check into database
	 * 
	 * @param inUsn: The login of student 
	 * @param inPwd: The user password
	 * @return: true if successful or false is not 
	 * @throws Exception
	 */
	private boolean checkConnexion(String inUsn, String inPwd) throws Exception{
		logger.info("Entring the method: checkConnexion(String)");
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudentModel> StudentDAO = adf.getDAO_SchoolStudent() ;
			
			logger.info("Exitring the method: checkConnexion(String)");
			return ((DAO_SchoolStudent) StudentDAO).SchoolStudentExist(inUsn, inPwd);
		} catch (Exception ex) {
			logger.info("Exiting the method: checkConnexion(String)");
			throw ex;
		}	
	}
	
	/**
	 * This method return a student whose name is passed as a parameter
	 * 
	 * @param usn: The login of the student
	 * @return A student or null if he doesn't exist
	 * @throws Exception
	 */
	private SchoolStudentModel createStudent(String inUsn) throws Exception{
		logger.info("Entring the method: createStudent(String)");

		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudentModel> StudentDAO = adf.getDAO_SchoolStudent() ;
			
			logger.info("Exiting the method: createStudent(String)");
			return ((DAO_SchoolStudent) StudentDAO).find(inUsn);
		} catch (Exception ex) {
			logger.info("Exiting the method: createStudent(String)");
			throw ex;
		}
	}
	
	/**
	 * This method allow to check member connection before we use the application
	 * 
	 * @param inUsn: The member login
	 * @param inPwd: The user password
	 * @return: True if the connection is successfully or false
	 */
	private boolean connexionMember(String inUsn, String inPwd){
		logger.info("Entring the method: connexionMember(String)");
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolMemberModel> MemberDAO = adf.getDAO_SchoolMember();
			
			logger.info("Exiting the method: connexionMember(String)");
			return ((DAO_SchoolMember) MemberDAO).SchoolMemberExist(inUsn, inPwd);
		} catch(Exception ex) {
			logger.info("Exiting the method: connexionMember(String) " + ex.getMessage());
			return false;
		}
	}
	
	/**
	 * This method return a member whose login is passed as a parameter
	 * 
	 * @param usn: the member login
	 * @return: A member or null if he doesn't exist
	 * @throws Exception
	 */
	private SchoolMemberModel findMember(String inUsn) throws Exception{	
		logger.info("Entring the method: createMember(String)");

		try{
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();		
			DAO_JEE<SchoolMemberModel> MemberDAO = adf.getDAO_SchoolMember();
			
			logger.info("Exiting the method: createMember(String)");
			return ((DAO_SchoolMember) MemberDAO).find(inUsn);
		
		} catch(Exception ex){
			logger.info("Exiting the method: createMember(String) " + ex.getMessage());
			throw ex;
		}
	}
}