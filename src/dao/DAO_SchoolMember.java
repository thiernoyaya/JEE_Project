package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import Models.*;

public class DAO_SchoolMember extends DAO_JEE<SchoolMemberModel>{

	public DAO_SchoolMember(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(SchoolMemberModel obj) {
		try {
			String sql = "{call pro_schmemberinsert(?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.setString(1, obj.getUsn());
			call.setString(2, obj.getPwd());
			call.setString(3, obj.getFirstName());
			call.setString(4, obj.getLastName());
			call.setInt(5, (obj.getFactive() == true ? 1 : 0));
			call.setString(6, obj.getMail());
			call.setString(7, obj.getTel());
			call.setInt(8, (obj.getFlagCoordinator() == true ? 1 : 0));
			call.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean delete(SchoolMemberModel obj) {
		return true;
	}

	@Override
	public boolean update(SchoolMemberModel obj) throws Exception {
		try {
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getUsn());
			call.execute();
			int idUser = call.getInt(1);
			sql = "{call pro_schmemberupdate(?, ?, ?, ?, ?, ?, ?}";
			call = connect.prepareCall(sql);
			call.setInt(1, idUser);
			call.setString(2, obj.getPwd());
			call.setString(3, obj.getFirstName());
			call.setString(4, obj.getLastName());
			call.setString(5, obj.getMail());
			call.setString(6, obj.getTel());
			call.setInt(7, (obj.getFlagCoordinator() == true ? 1 : 0));
			call.execute();
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public boolean chngPwd(SchoolMemberModel obj) {
		try {
			String sql = "{call pro_userchngpwd(?, ?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.setString(1, obj.getUsn());
			call.setString(2, obj.getPwd());
			call.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public SchoolMemberModel find(String usn) throws Exception {
		try {
			String sql = "{? = call fct_schmemberexist(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, usn);
			call.execute();
			int nbElem = call.getInt(1);
			if (nbElem == 1) {
				sql = "SELECT usn, pwd, fname, lname, mail, factive, tel, fcoordinator "
					+ "FROM jee_user INNER JOIN jee_schoolmember USING (iduser) "
					+ "WHERE usn = '" + usn + "'";
				Statement stmt = connect.createStatement();
				ResultSet res =  stmt.executeQuery(sql);
				res.next();
				SchoolMemberModel sm = new SchoolMemberModel(res.getString("usn"), res.getString("pwd"), 
						res.getString("fname"), res.getString("lname"), res.getString("mail"), 
						(res.getInt("factive") == 1 ? true : false), res.getString("tel"), 
						(res.getInt("fcoordinator") == 1 ? true : false));
				return sm;
			} else {
				throw new Exception(String.valueOf(nbElem));
			} 
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public Set<SchoolMemberModel> findListMembreOfschool(boolean spv) {
		try {
			Set<SchoolMemberModel> list = new HashSet<>();
			String sql = "SELECT usn "
					   + "FROM jee_user INNER JOIN jee_schoolmember USING (iduser) "
					   + "WHERE fcoordinator = " + (spv ? 0 : 1);
			Statement stmt = connect.createStatement();
			ResultSet res =  stmt.executeQuery(sql);
			while (res.next()) {
				SchoolMemberModel sm = find(res.getString("usn"));
				if (!list.contains(sm))
					list.add(sm);
			}
			return list;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public boolean SchoolMemberExist(String inUn, String inPwd) {
		try {
			String sql = "{? = call fct_schmemberexist(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, inUn);
			call.execute();
			int idUser = call.getInt(1);
			if (idUser > 0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/********retrouver les eleves d'un profs 
	 * @throws Exception ***************/
	public SchoolMemberModel findList(String usn) throws Exception {
		SchoolMemberModel sm = find(usn);
		try {
			//ArrayList<SchoolStudent> list = new ArrayList<SchoolStudent>();
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, usn);
			call.execute();
			int idSpv = call.getInt(1);
			sql = "SELECT usn "
				+ "FROM jee_user INNER JOIN jee_student USING (iduser) "
				+ "WHERE idsuperv = " + idSpv;
			Statement stmt = connect.createStatement();
			ResultSet res =  stmt.executeQuery(sql);
			
			DAO_SchoolStudent studentDAO = new DAO_SchoolStudent(this.connect);
			while (res.next()) {
				//SchoolStudent ss = find(res.getString("usn"));
				sm.addStudent(studentDAO.find(res.getString("usn")));
				/*if (!list.contains(ss))
					list.add(ss);*/
			}
			return sm;
		} catch (Exception ex) {
			return null;
		}
	}
}
