package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/*import java.sql.PreparedStatement;
import java.sql.SQLException;*/
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import PojoBean.*;

public class DAO_SchoolStudent extends DAO_JEE<SchoolStudent> {

	public DAO_SchoolStudent(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(SchoolStudent obj) {
		try {
			// Récupération IDCoordinateur
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getCoordinator().getUsn());
			call.execute();
			int idCoord = call.getInt(1);
			
			// Récupération IDSuperviseur
			sql = "{? = call fct_retrieveiduser(?)}";
			call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getSupervisor().getUsn());
			call.execute();
			int idSuperv = call.getInt(1);
			
			// Récupération IDEtudiant
			sql = "{? = call fct_retrieveiduser(?)}";
			call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getUsn());
			call.execute();
			int idStudent = call.getInt(1);
			
			// Insertion de l'étudiant
			sql = "{call pro_studentinsert(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			call = connect.prepareCall(sql);
			call.setInt(1, idStudent);
			call.setInt(2, idCoord);
			call.setInt(3, idSuperv);
			call.setString(4, obj.getNISS());
			call.setString(5, obj.getZipCode());
			call.setString(6, obj.getCity());
			call.setString(7, obj.getStreet());
			call.setString(8, obj.getStreetNB());
			call.setString(9, obj.getStreetBox());
			call.setString(10, obj.getTel());
			call.setString(11, obj.getSection());
			call.setString(12, obj.getCategory());
			call.setString(13, obj.getEstablishment());
			if (call.execute())
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean createStudentUser(SchoolStudent obj) {
		try {
			// Insertion de l'utilisateur
			String sql = "{call pro_userinster(?, ?, ?, ?, ?, ?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.setString(1, obj.getUsn());
			call.setString(2, obj.getPwd());
			call.setString(3, obj.getFirstName());
			call.setString(4, obj.getLastName());
			call.setString(5, obj.getMail());
			call.setInt(6, (obj.getFactive() == true ? 1 : 0));
			call.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean delete(SchoolStudent obj) {
		return true;
	}

	@Override
	public boolean update(SchoolStudent obj) throws Exception {
		try {
			
			// Récupération de l'ID Utilisateur
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getUsn());
			call.execute();
			int idUser = call.getInt(1);
			
			// Récupération de l'ID Coordinateur
			sql = "{? = call fct_retrieveiduser(?)}";
			call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getCoordinator().getUsn());
			call.execute();
			int idCoord = call.getInt(1);
			
			// Récupération de l'ID Superviseur
			sql = "{? = call fct_retrieveiduser(?)}";
			call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getSupervisor().getUsn());
			call.execute();
			int idSuperv = call.getInt(1);
			
			// Mise à jour de l'étudiant
			sql = "{call pro_studentupdate(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			call = connect.prepareCall(sql);
			call.setInt(1, idUser);
			call.setString(2, obj.getPwd());
			call.setString(3, obj.getFirstName());
			call.setString(4, obj.getLastName());
			call.setString(5, obj.getMail());
			call.setInt(6, idCoord);
			call.setInt(7, idSuperv);
			call.setString(8, obj.getNISS());
			call.setString(9, obj.getZipCode());
			call.setString(10, obj.getCity());
			call.setString(11, obj.getStreet());
			call.setString(12, obj.getStreetNB());
			call.setString(13, obj.getStreetBox());
			call.setString(14, obj.getTel());
			call.setString(15, obj.getSection());
			call.setString(16, obj.getCategory());
			call.setString(17, obj.getEstablishment());
			call.execute();
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public boolean chngPwd(SchoolMember obj) {
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
	
	public SchoolStudent find(String usn) throws Exception {
		try {
			SchoolMember coord;
			SchoolMember superv;
			String sql = "{? = call fct_studentexist(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, usn);
			call.execute();
			int nbElem = call.getInt(1);
			if (nbElem == 1) {
				sql = "SELECT usn, pwd, fname, lname, mail, factive, idcoord, idsuperv, niss, zipcode"
					+ ", city, street, streetnb, streetbox, tel, sect, cat, estbl "
					+ "FROM jee_user INNER JOIN jee_student USING (iduser) "
					+ "WHERE usn = '" + usn + "'";
				Statement stmt = connect.createStatement();
				ResultSet res =  stmt.executeQuery(sql);
				if(res.next()) {
					String sql2 = "SELECT usn, pwd, fname, lname, mail, factive, tel, fcoordinator "
								+ "FROM jee_user INNER JOIN jee_schoolmember USING (iduser) "
								+ "WHERE iduser = " + res.getInt("idcoord");
					Statement stmt2 = connect.createStatement();
					ResultSet res2 =  stmt2.executeQuery(sql2);
					if (res2.next()) {				
						coord = new SchoolMember(res2.getString("usn"), res2.getString("pwd"), 
							res2.getString("fname"), res2.getString("lname"), res2.getString("mail"), 
							(res2.getInt("factive") == 1 ? true : false), res2.getString("tel"), 
							(res2.getInt("fcoordinator") == 1 ? true : false));
					} else {
						coord = new SchoolMember();
					}
					sql2 = "SELECT usn, pwd, fname, lname, mail, factive, tel, fcoordinator "
						 + "FROM jee_user INNER JOIN jee_schoolmember USING (iduser) "
						 + "WHERE iduser = " + res.getInt("idcoord");
					stmt2 = connect.createStatement();
					res2 =  stmt2.executeQuery(sql2);
					if (res2.next()) {
						superv = new SchoolMember(res2.getString("usn"), res2.getString("pwd"), 
							res2.getString("fname"), res2.getString("lname"), res2.getString("mail"), 
							(res2.getInt("factive") == 1 ? true : false), res2.getString("tel"), 
							(res2.getInt("fcoordinator") == 1 ? true : false));
					} else {
						superv = new SchoolMember();
					}
					SchoolStudent ss = new SchoolStudent(res.getString("usn"), res.getString("pwd"), 
							res.getString("fname"), res.getString("lname"), res.getString("mail"), 
							(res.getInt("factive") == 1 ? true : false), coord, superv, res.getString("NISS"),
							res.getString("zipcode"), res.getString("city"), res.getString("street"),
							res.getString("streetnb"), res.getString("streetbox"), res.getString("tel"),
							res.getString("sect"), res.getString("cat"), res.getString("estbl"));
					return ss;
				} else {
					throw new Exception("L'utilisateur choisi n'existe pas");
				}
			} else {
				throw new Exception(String.valueOf(nbElem));
			} 
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<SchoolStudent> findList(String usn) {
		try {
			ArrayList<SchoolStudent> list = new ArrayList<SchoolStudent>();
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
			while (res.next()) {
				SchoolStudent ss = find(res.getString("usn"));
				if (!list.contains(ss))
					list.add(ss);
			}
			return list;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public Set<SchoolStudent> findAllStudent() {
		try {
			Set<SchoolStudent> list = new HashSet<>();
			String sql = "SELECT usn, pwd, fname, lname, mail, factive, idcoord, idsuperv, niss, zipcode"
					+ ", city, street, streetnb, streetbox, tel, sect, cat, estbl "
					+ "FROM jee_user INNER JOIN jee_student USING (iduser) ";
			Statement stmt = connect.createStatement();
			ResultSet res =  stmt.executeQuery(sql);
			while (res.next()) {
				SchoolStudent ss = find(res.getString("usn"));
				if (!list.contains(ss))
					list.add(ss);
			}
			return list;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public boolean SchoolStudentExist(String usn) {
		try {
			String sql = "{? = call fct_studentexist(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, usn);
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
}
