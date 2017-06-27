package DAO;


import java.sql.Connection;

/*import PojoBean.SchoolCoordinator;
import PojoBean.SchoolStudent;
import PojoBean.StageHours;
import PojoBean.User;
import PojoBean.Stage;*/
import PojoBean.*;

public class FACTORY_DAO extends  AbstractDAOFactory {

	protected static Connection conn;
	
	/*@Override
	public DAO_JEE<User> getDAO_User() {
		return new DAO_User(conn);
	}*/

	@Override
	public DAO_JEE<SchoolMember> getDAO_SchoolMember() throws Exception {
		try {
			conn = Driver_DBOracle.getInstance();
			return new DAO_SchoolMember(conn);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/*@Override
	public DAO_JEE<SchoolTeachers> getDAO_SchoolTeachers() {
		return new DAO_SchoolTeachers(conn);
	}*/

	@Override
	public DAO_JEE<SchoolStudent> getDAO_SchoolStudent() throws Exception {
		try {
			conn = Driver_DBOracle.getInstance();
			return new DAO_SchoolStudent(conn);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public DAO_JEE<Stage> getDAO_Stage() throws Exception {
		try {
			conn = Driver_DBOracle.getInstance();
			return new DAO_Stage(conn);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/*@Override
	public DAO_JEE<StageHours> getDAO_StageHours() {
		return new DAO_StageHours(conn);
	}*/
	
}
