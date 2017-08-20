package DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class Driver_DBOracle {
	
	private static Connection snglConnection = null;
	
	private  Driver_DBOracle() throws Exception{
		String url1 = "jdbc:oracle:thin:exa8/examen@char-oracle11.condorcet.be:1521/XE";		
		try {
		    Class.forName("oracle.jdbc.OracleDriver");
		    snglConnection = DriverManager.getConnection(url1);			
		} catch(Exception ex) {
			throw ex;
		}			
	}
	
	public static Connection getInstance() throws Exception {
		try {
			if (snglConnection == null) {
				new  Driver_DBOracle();
			}
			return snglConnection;
		} catch (Exception ex) {
			throw ex;
		}
	}
}

		

