package DAO;

import PojoBean.SchoolMember;
import PojoBean.SchoolStudent;
import PojoBean.Stage;

public abstract class AbstractDAOFactory {
	
	//public static final int DAO_FACTORY = 0;
	//public static final int XML_DAO_FACTORY = 1;
	
	/*public abstract DAO_JEE<User> getDAO_User();*/
	public abstract DAO_JEE<SchoolMember> getDAO_SchoolMember() throws Exception;
	/*public abstract DAO_JEE<SchoolTeachers> getDAO_SchoolTeachers();*/
	public abstract DAO_JEE<SchoolStudent> getDAO_SchoolStudent() throws Exception;
	public abstract DAO_JEE<Stage> getDAO_Stage() throws Exception;
	/*public abstract DAO_JEE<StageHours> getDAO_StageHours();*/
	
	public static AbstractDAOFactory getFactory() throws Exception{
		try {
			return new FACTORY_DAO();
		} catch (Exception ex) {
			throw ex;
		}
		
	}
}
