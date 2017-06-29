package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.sun.istack.logging.Logger;

import DAO.AbstractDAOFactory;
import DAO.DAO_JEE;
import DAO.DAO_SchoolMember;

public class SchoolMemberModel extends UserModel {	
	protected Logger logger = Logger.getLogger(SchoolMemberModel.class);

	/**
	 * The member tel
	 */
	private String tel;
	
	/**
	 * The status of member
	 */
	private boolean flag_coordinator;
	
	/**
	 * The list of stages
	 */
	private List<StageModel> listStage = new ArrayList<>();
	
	/**
	 *  The list of student
	 */
	private List<SchoolStudentModel> listStudent = new ArrayList<>();
	
	 
	public SchoolMemberModel(){
		super();
		this.tel = null;
		this.flag_coordinator = false;
	}
	
	public SchoolMemberModel(String usn, String pwd, String fname, String lname, String mail, boolean factive, String tel, boolean fcoordinator) {
		super(usn, pwd, fname, lname, mail, factive);
		this.tel = tel;
		this.flag_coordinator = fcoordinator;
	}
	
	
	/**
	 * 
	 * @return the tel of memeber
	 */
	public String getTel() { 
		return this.tel; 
	}
	
	/**
	 * 
	 * @return the status of member
	 */
	public boolean getFlagCoordinator() { 
		return this.flag_coordinator; 
	}
	
	/**
	 * 
	 * @return the list of student whose do the intership
	 */
	public List<SchoolStudentModel> getListStudent() { 
		return this.listStudent; 
	}
	
	/**
	 * 
	 * @param value: set the tel value
	 */
 	public void setTel(String value) { 
 		this.tel = value; 
 	}
 	
 	/**
 	 * 
 	 * @param value: set the status of memeber
 	 */
	public void setFlagCoordinator(boolean value) { 
		this.flag_coordinator = value;
	}
	
    /**
     * 
     * @param stage: add the intership into list
     * @return true if the intership add successfully neither false
     */
	public boolean addStage (StageModel stage) {
		if (!this.listStage.contains(stage)){
			this.listStage.add(stage);
			return true;
		} else
			return false;
	}
	
	/**
	 * 
	 * @param stage: remove the intership into the list
	 */
	public void removeStage (StageModel stage) {
		if (this.listStage.contains(stage))
			this.listStage.remove(stage);
	}
	
	/**
	 * 
	 * @param student: add the student into list
	 * @return true if successfully neither false
	 */
	public boolean addStudent(SchoolStudentModel student){
		if(!this.listStudent.contains(student)) {
			this.listStudent.add(student);
			return true;
		} else
			return false;
	}
	
	/**
	 * 
	 * @param student: remove the student into list
	 */
	public void removeStudent(SchoolStudentModel student){
		if (this.listStudent.contains(student))
			this.listStudent.remove(student);
	}
	
 	
	/**
	 * This method allows us to get a list of teacher student
	 * 
	 * @param inUsn: the username of teacher
	 * @return A member inwhcih we have a list of student
	 * @throws Exception
	 */
	public SchoolMemberModel listOfProfStudent(String inUsn) throws Exception{
		logger.info("Entering the method: listOfProfStudent(String)");
		if(inUsn.isEmpty()){
			logger.info("inUsn must be initialized");
			logger.info("Exiting the method: listOfProfStudent(String)");
			throw new Exception("The login doesn't be empty");
		}
		
		logger.info("Exiting the method: listOfProfStudent(String)");
		return listOfStudent(inUsn);
	}
	
	/**
	 * This method enable to get a list of school member
	 * 
	 * @param inSpv: The status of school member
	 * @return a memeber neither null 
	 * @throws Exception
	 */
 	public Set< SchoolMemberModel> listOfSchoolMember(boolean inSpv) throws Exception{
 		logger.info("Entering the method: listOfSchoolMember(boolean)");
		return  memberOfschool(inSpv);
	}
 	
 	
	
	/**
	 * 
	 * This method allows to find the member who name passed parameter
	 * 
	 * @param inUsn: the member name
	 * @return The member or null if it doesn't find
	 * @throws Exception
	 */
	public SchoolMemberModel findMember(String inUsn) throws Exception{
		logger.info("Entering the method: findMember(String)");
		
		if(inUsn.isEmpty()){
			logger.info("inUsn must be initialized");
			logger.info("Exiting the metod: findMember(String)");
			throw new Exception("The paramerer must be initialized");
		}
		
		logger.info("Exiting the method: findMember(String)");
		return  findSchoolMember(inUsn);
	}
	
	/**
	 * This method allows to get the list of all student 
	 * 
	 * @return The list of all student
	 * @throws Exception
	 */
	public Set<SchoolStudentModel> listStudent() throws Exception{
		logger.info("Entering the method: listStudent()");
		return SchoolStudentModel.listOfALLStudent();
	}

	
	/**
	 * This method establissed the connection with the DB and allows to 
	 * get the teacher student
	 * 
	 * @param inUsn: The user name 
	 * @return The teacher with it's student
	 * @throws Exception
	 */
	private SchoolMemberModel listOfStudent(String inUsn) throws Exception{		
		try{
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();		
			DAO_JEE<SchoolMemberModel> MemberDAO = adf.getDAO_SchoolMember();
			return ((DAO_SchoolMember) MemberDAO).findList(inUsn);
		
		} catch(Exception ex) {
			throw ex;
		}		
	}
	
 	/**
	 * This method allows to get various member of school
	 * 
	 * @param inSpv: The type of member
	 * @return The member or null if it doesn't find
	 * @throws Exception
	 */
	private Set<SchoolMemberModel> memberOfschool( boolean inSpv) throws Exception{
		try{
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();		
			DAO_JEE<SchoolMemberModel> MemberDAO = adf.getDAO_SchoolMember();
			return ((DAO_SchoolMember) MemberDAO).findListMembreOfschool(inSpv);
		
		} catch(Exception ex) {
			throw ex;
		}			
	}
	
 	/**
	 * This method return a specific member passed parameter 
	 * 
	 * @param usn: The member name
	 * @return member or null 
	 * @throws Exception
	 */
	private SchoolMemberModel findSchoolMember(String usn) throws Exception{
		try{
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();		
			DAO_JEE<SchoolMemberModel> MemberDAO = adf.getDAO_SchoolMember();
			return ((DAO_SchoolMember) MemberDAO).find(usn);
		
		} catch(Exception ex) 
		{
			throw ex;
		}
	}
	
	
}
