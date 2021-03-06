package DAO;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Types;

import Beans.Stage;
import Models.SchoolStudentModel;
import Models.StageModel;
import Models.StageHoursModel;

import java.sql.Date;
import java.sql.ResultSet;


public class DAO_Stage extends DAO_JEE<StageModel>{

	public DAO_Stage(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(StageModel obj) {
		try {
			// R�cup�ration de l'ID de l'�tudiant
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getStudent().getUsn());
			call.execute();
			int idStudent = call.getInt(1);
			
			// Insertion du stage
			sql = "{call PRO_StageInsert(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			call = connect.prepareCall(sql);
			call.setInt(1, idStudent);
			call.setString(2, obj.getEntName());
			call.setString(3, obj.getEntSupervisorName());
			call.setString(4, obj.getEntSupervisorMail());
			call.setString(5, obj.getEntSupervisorTel());
			call.setString(6, obj.getEntSupervisorFax());
			call.setString(7, obj.getEntCountry());
			call.setString(8, obj.getEntState());
			call.setString(9, obj.getEntZipCode());
			call.setString(10, obj.getEntCity());
			call.setString(11, obj.getEntStreet());
			call.setString(12, obj.getEntStreetNB());
			call.setString(13, obj.getEntStreetBox());
			call.setDate(14, obj.getDateBegin());
			call.setDate(15, obj.getDateEnd());
			call.setString(16, obj.getTFETheme());
			call.execute();
			if (obj.getListStageHours().size() > 0)
				return insupdStageHours(obj);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean delete(StageModel obj) {
		return true;
	}

	@Override
	public boolean update(StageModel obj) {
		try {
			
			// R�cup�ration de l'ID de l'�tudiant
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getStudent().getUsn());
			call.execute();
			int idStudent = call.getInt(1);
			
			// R�cup�ration de l'ID du stage
			sql = "{? = call fct_retrieveidstage(?, ?, ?)}";
			call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setInt(2, idStudent);
			call.setDate(3, obj.getDateBegin());
			call.setDate(4, obj.getDateEnd());
			call.execute();
			int idStage = call.getInt(1);
			
			// Mise � jour du stage
			sql = "{call PRO_StageInsert(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			call = connect.prepareCall(sql);
			call.setInt(1, idStage);
			call.setInt(2, idStudent);
			call.setString(3, obj.getEntName());
			call.setString(4, obj.getEntSupervisorName());
			call.setString(5, obj.getEntSupervisorMail());
			call.setString(6, obj.getEntSupervisorTel());
			call.setString(7, obj.getEntSupervisorFax());
			call.setString(8, obj.getEntCountry());
			call.setString(9, obj.getEntState());
			call.setString(10, obj.getEntZipCode());
			call.setString(11, obj.getEntCity());
			call.setString(12, obj.getEntStreet());
			call.setString(13, obj.getEntStreetNB());
			call.setString(14, obj.getEntStreetBox());
			call.setDate(15, obj.getDateBegin());
			call.setDate(16, obj.getDateEnd());
			call.setString(17, obj.getTFETheme());
			call.execute();
			if (obj.getListStageHours().size() > 0)
				return insupdStageHours(obj);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public StageModel find(SchoolStudentModel stu, Date dateBeg, Date dateEnd) {
		try {
			// R�cup�ration de l'ID de l'�tudiant
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, stu.getUsn());
			call.execute();
			int idStudent = call.getInt(1);
			
			// R�cup�ration du stage
			sql = "SELECT * FROM jee_stage WHERE idstudent = " + idStudent + " AND datebeg = '" + dateBeg 
				+ "' AND dateend = '" + dateEnd + "'";
			Statement stmt = connect.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			StageModel s = new StageModel(stu, res.getString("entname"), res.getString("entspvname"), 
					res.getString("entspvmail"), res.getString("entspvtel"), res.getString("entspvfax"),
					res.getString("entcountry"), res.getString("entstate"), res.getString("entzipcode"),
					res.getString("entcity"), res.getString("entstreet"), res.getString("entstreetnb"),
					res.getString("entstreetbox"), res.getDate("datebeg"), res.getDate("dateend"),
					res.getString("tfetheme"));
			
			// V�rification si il existe des stagehours
			sql = "SELECT * FROM jee_stagehours WHERE idstage = " + res.getInt("idstage");
			stmt = connect.createStatement();
			res = stmt.executeQuery(sql);
			while (res.next()) {
				StageHoursModel sh = new StageHoursModel(res.getString("nameday"), res.getString("hrbegam"),
						res.getString("hrendam"), res.getString("hrbegpm"), res.getString("hrendpm"));
				s.addStageHour(sh);
			}
			
			return s;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public boolean insupdStageHours(StageModel obj) throws Exception {
		try {
			// R�cup�ration de l'ID de l'�tudiant
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, obj.getStudent().getUsn());
			call.execute();
			int idStudent = call.getInt(1);
			
			// R�cup�ration de l'ID du stage
			sql = "{? = call fct_retrieveidstage(?, ?, ?)}";
			call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setInt(2, idStudent);
			call.setDate(3, obj.getDateBegin());
			call.setDate(4, obj.getDateEnd());
			call.execute();
			int idStage = call.getInt(1);
			
			for(StageHoursModel sh : obj.getListStageHours()) {
				
				// V�rification que le stageHours existe
				sql = "{? = call fct_stagehoursexist(?, ?)}";
				call = connect.prepareCall(sql);
				call.registerOutParameter(1, Types.INTEGER);
				call.setInt(2, idStage);
				call.setString(3, sh.getNameDay());
				call.execute();
				boolean insert = call.getInt(1) == 0;
				
				// Ex�cution de la commande sql
				sql = "{call pro_stagehours" + (insert ? "insert" : "update") +"(?, ?, ?, ?, ?, ?)}";
				call = connect.prepareCall(sql);
				call.setInt(1, idStage);
				call.setString(2, sh.getNameDay());
				call.setString(3, sh.getHeureBeginAM());
				call.setString(4, sh.getHeureEndAM());
				call.setString(5, sh.getHeureBeginPM());
				call.setString(6, sh.getHeureEndPM());
				call.execute();
			}
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	
	/***********Afficher le stage d'un �tudiant*****************************************/
	public Stage findStudentStage(SchoolStudentModel stu) {
		Stage stage = new Stage(); 
		try {
			// R�cup�ration de l'ID de l'�tudiant
			String sql = "{? = call fct_retrieveiduser(?)}";
			CallableStatement call = connect.prepareCall(sql);
			call.registerOutParameter(1, Types.INTEGER);
			call.setString(2, stu.getUsn());
			call.execute();
			int idStudent = call.getInt(1);
			
			// R�cup�ration du stage
			if(idStudent > 0 ){
				sql = "SELECT * FROM jee_stage WHERE idstudent = " + idStudent ;
				Statement stmt = connect.createStatement();
				ResultSet res = stmt.executeQuery(sql);
				res.next();
				
				stage.setStudent(stu);
				stage.setEntName(res.getString("entname"));
				stage.setEntSpvName(res.getString("entspvname"));
				stage.setEntSpvMail(res.getString("entspvmail"));
				stage.setEntSpvTel(res.getString("entspvtel"));
				stage.setEntSpvFax(res.getString("entspvfax"));
				stage.setEntCountry(res.getString("entcountry"));
				stage.setEntState(res.getString("entstate"));
				stage.setEntZipCode(res.getString("entzipcode"));
				stage.setEntCity(res.getString("entcity"));
				stage.setEntStreet(res.getString("entstreet"));
				stage.setEntStreetNB(res.getString("entstreetnb"));
				stage.setEntStreetBox(res.getString("entstreetbox"));
				stage.setDateBegin(res.getDate("datebeg"));
				stage.setDateEnd(res.getDate("dateend"));
				stage.setTfeTheme(res.getString("tfetheme"));
				/*StageModel s = new StageModel(stu, res.getString("entname"), res.getString("entspvname"), 
						res.getString("entspvmail"), res.getString("entspvtel"), res.getString("entspvfax"),
						res.getString("entcountry"), res.getString("entstate"), res.getString("entzipcode"),
						res.getString("entcity"), res.getString("entstreet"), res.getString("entstreetnb"),
						res.getString("entstreetbox"), res.getDate("datebeg"), res.getDate("dateend"),
						res.getString("tfetheme"));*/
				return stage;
			}
			else {
				throw new Exception(String.valueOf(idStudent));
			} 
		} catch (Exception ex) {
			return null;
		}
	}
}
