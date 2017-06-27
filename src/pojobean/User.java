package PojoBean;

import Model.DB_SchoolMember;
import Model.DB_SchoolStudent;

public class User {
	
	/*************Membres d'instanciation******************************/
	// revoir le principes des bean
	private String usn;
	private String pwd;
	private boolean factive;
	private String f_name;
	private String l_name;
	private String mail;
		
	/*************Constructeurs****************************************/
	public  User(){
		this.usn = null;
		this.pwd = null;
		this.factive = false;
		this.f_name = null;
		this.l_name = null;
		this.mail = null;
	}
	
	public User(String usn, String pwd, String fName, String lName, String mail, boolean flag_ac){
		this.usn = usn;
		this.pwd  = pwd;
		this.factive = flag_ac;
		this.f_name = fName;
		this.l_name = lName;
		this.mail = mail;
	}
	public User( String fName, String lName, String mail, boolean flag_ac){
		this.factive = flag_ac;
		this.f_name = fName;
		this.l_name = lName;
		this.mail = mail;
	}

	public User(String usn2, String pwd2, boolean factive2) {
		usn = usn2;
		pwd = pwd2;
		factive = factive2;
	}

	/***********************getters****************************************/
	public String getUsn() { return this.usn; }
	public String getPwd() { return this.pwd; }
	public boolean getFactive() { return this.factive; }
	public String getFirstName() { return this.f_name; }
	public String getLastName() { return this.l_name; }
	public String getMail(){ return this.mail; }
	
	/***********************setters****************************************/
	public void setUsn(String value) { this.usn = value; }
	public void setPwd(String value) { this.pwd = value; }
	public void setFactive(boolean value) { this.factive = value; }	
	public void setFirstName(String value) { this.f_name = value; }	
	public void setLastName(String value) { this.l_name = value; }	
	public void setMail(String value) { this.mail = value; }
	
	
	/***********************méthodes publiques*****************************/
	public Object login(String usn) throws Exception{
		try {
			if(!usn.isEmpty()){		   
			   if(DB_SchoolStudent.connexion(usn)){
				   SchoolStudent obj = DB_SchoolStudent.createStudent(usn);
				   if (obj == null)
					   throw new Exception("Objet NULL");
				   else 
					   return obj;
			   }
			   else{			   
				   if(DB_SchoolMember.connexionMember(usn)){				   
					   SchoolMember obj = DB_SchoolMember.createMember(usn);
					   if (obj == null)
						   throw new Exception("Objet NULL");
					   else 
						   return obj;
				   }
				   else
					   throw new Exception("nom d'utilisateur ou mot de passe incorrect"); 
			   }
			}
			else{
				throw new Exception("Merci de remplir les champs vide!");
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}