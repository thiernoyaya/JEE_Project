package Model;

import java.util.ArrayList;
import java.util.Set;

import DAO.AbstractDAOFactory;
import DAO.DAO_JEE;
import DAO.DAO_SchoolStudent;
import PojoBean.SchoolStudent;

public abstract class DB_SchoolStudent {
	public static boolean connexion(String usn) throws Exception{
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudent> StudentDAO = adf.getDAO_SchoolStudent() ;
			return ((DAO_SchoolStudent) StudentDAO).SchoolStudentExist(usn);
		} catch (Exception ex) {
			throw ex;
		}
	
	}
	
	public static SchoolStudent createStudent(String usn) throws Exception{
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudent> StudentDAO = adf.getDAO_SchoolStudent() ;
			return ((DAO_SchoolStudent) StudentDAO).find(usn);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public static ArrayList<SchoolStudent> lisOfStudentSpv(String spv) throws Exception { 
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudent> StudentDAO = adf.getDAO_SchoolStudent() ;
			return ((DAO_SchoolStudent) StudentDAO).findList(spv);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public static boolean create(SchoolStudent obj) throws Exception{
		    AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudent> StudentDAO = adf.getDAO_SchoolStudent() ;
			return ((DAO_SchoolStudent) StudentDAO).update(obj);		
	}
	
	/*** liste de tous les étudiants **************************************/
	public static Set<SchoolStudent> allStudent() throws Exception{
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolStudent> StudentDAO = adf.getDAO_SchoolStudent() ;
			return ((DAO_SchoolStudent) StudentDAO).findAllStudent();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
