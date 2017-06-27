package PojoBean;

import java.util.HashSet;
import java.util.Set;

import Model.DB_SchoolMember;


public class SchoolMember extends User {
	
	/*************Membres d'instanciation******************************/
	private String tel;
	private boolean flag_coordinator;
	private Set<Stage> listStage = new HashSet<>();
	private Set<SchoolStudent> listStudent = new HashSet<>();
	
	/**************Constructeurs***************************************/
	public SchoolMember(){
		super();
		this.tel = null;
		this.flag_coordinator = false;
	}
	
	public SchoolMember(String usn, String pwd, String fname, String lname, String mail, boolean factive, String tel, boolean fcoordinator) {
		super(usn, pwd, fname, lname, mail, factive);
		this.tel = tel;
		this.flag_coordinator = fcoordinator;
	}
	
	
	/***********************getters****************************************/
	public String getTel() { return this.tel; }
	public boolean getFlagCoordinator() { return this.flag_coordinator; }
	public Set<SchoolStudent> getListStudent() { return this.listStudent; }
	
	/***********************setters****************************************/
	public void setTel(String value) { this.tel = value; }
	public void setFlagCoordinator(boolean value) { this.flag_coordinator = value; }
	
	/***********************méthodes publiques*****************************/
	public boolean addStage (Stage s) {
		if (!this.listStage.contains(s)){
			this.listStage.add(s);
			return true;
		} else
			return false;
	}
	
	public void removeStage (Stage s) {
		if (this.listStage.contains(s))
			this.listStage.remove(s);
	}
	
	public boolean addStudent(SchoolStudent s){
		if(!this.listStudent.contains(s)) {
			this.listStudent.add(s);
			return true;
		} else
			return false;
	}
	public void removeStudent(SchoolStudent s){
		if (this.listStudent.contains(s))
			this.listStudent.remove(s);
	}
	
	// liste des étudiants d'un prof
	public static SchoolMember listeDesEtudiant(String usn) throws Exception{
		return DB_SchoolMember.listOfStudent(usn);
	}
	
	// retourne l'ensemble des schoolMember preciser en parametre
	public static Set< SchoolMember> listOfSchoolMember(boolean spv) throws Exception{
		return DB_SchoolMember.memberOfschool(spv);
	}
	
	//retourne un objet schoolMember
	public static SchoolMember find(String usn) throws Exception{
		return DB_SchoolMember.findSchoolMember(usn);
	}
	
	public Set<SchoolStudent> listStudent() throws Exception{
		return SchoolStudent.listOfALLStudent();
	}

}
