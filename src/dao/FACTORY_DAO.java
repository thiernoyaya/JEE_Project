package DAO;


import java.sql.Connection;

import Models.*;

public class FACTORY_DAO extends  AbstractDAOFactory {

	protected static Connection conn;
	
	/*@Override
	public DAO_JEE<User> getDAO_User() {
		return new DAO_User(conn);
	}*/

	@Override
	public DAO_JEE<SchoolMemberModel> getDAO_SchoolMember() throws Exception {
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
	public DAO_JEE<SchoolStudentModel> getDAO_SchoolStudent() throws Exception {
		try {
			conn = Driver_DBOracle.getInstance();
			return new DAO_SchoolStudent(conn);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public DAO_JEE<StageModel> getDAO_Stage() throws Exception {
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
