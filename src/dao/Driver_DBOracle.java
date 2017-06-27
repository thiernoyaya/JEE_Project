package DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class Driver_DBOracle {
	
	private static Connection snglConnection = null;
	
	private  Driver_DBOracle() throws Exception{
		String url1 = "jdbc:oracle:thin:exa8/examen@char-oracle11.condorcet.be:1521/XE";
		/*String url1 = "jdbc:oracle:thin:jeeproject/pwd@sonikorg.ddns.net:1521/XE";*/ // Utile en cas que le serveur de l'école ne réponde pas
		
		try {
			//chargement de la classe du driver par la jvm qui correspond à la base oracle qu'on va utiliser
		    Class.forName("oracle.jdbc.OracleDriver");
			/*Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");*/
		    snglConnection = DriverManager.getConnection(url1);			
		/*} catch(ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Classe driver introuvable " + ex.getMessage());
			System.exit(0);
			throw ex;*/
		} catch(Exception ex) {
			/*JOptionPane.showMessageDialog(null, "Impossible de se connecter à  la base de donnée.");
			System.exit(0);*/
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

		

