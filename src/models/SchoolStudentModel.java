package Models;


import java.util.Set;

import DB.DB_SchoolStudent;

public class SchoolStudentModel extends UserModel{
	
	/*************Membres d'instanciation******************************/
	private SchoolMemberModel coordinator;
	private SchoolMemberModel supervisor;
	private StageModel stage = new StageModel();
	private String niss;
	private String zipCode;
	private String city;
	private String street;
	private String streetNB;
	private String streetBox;
	private String tel;
	private String section;
	private String category;
	private String establishment;
	
	/************ Constructeur *******************************************/
	public SchoolStudentModel(){
		super();
		this.coordinator = null;
		this.supervisor = null;
		this.niss = null;
		this.zipCode = null;
		this.city = null;
		this.street = null;
		this.streetNB = null;
		this.streetBox = null;
		this.tel = null;
		this.section = null;
		this.category = null;
		this.establishment = null;
	}
	
	public SchoolStudentModel(String usn, String pwd, String fname, String lname, String mail, boolean factive,
			SchoolMemberModel coordinator, SchoolMemberModel supervisor, String niss, String zipCode, String city,
			String street, String streetNB, String streetBox, String tel, String section, String category,
			String establishment) {
		super(usn, pwd, fname, lname, mail, factive);
		this.coordinator = coordinator;
		this.supervisor = supervisor;
		this.niss = niss;
		this.zipCode = zipCode;
		this.city = city;
		this.street = street;
		this.streetNB = streetNB;
		this.streetBox = streetBox;
		this.tel = tel;
		this.section = section;
		this.category = category;
		this.establishment = establishment;
	}
	
	public SchoolStudentModel( String fname, String lname, String mail, boolean factive,
			SchoolMemberModel coordinator, SchoolMemberModel supervisor, String niss, String zipCode, String city,
			String street, String streetNB,  String tel, String section, String category,
			String establishment) {
		super( fname, lname, mail, factive);
		this.coordinator = coordinator;
		this.supervisor = supervisor;
		this.niss = niss;
		this.zipCode = zipCode;
		this.city = city;
		this.street = street;
		this.streetNB = streetNB;
		this.tel = tel;
		this.section = section;
		this.category = category;
		this.establishment = establishment;
	}
	
	
	public SchoolStudentModel(String usn, String pwd,  boolean factive) {
		super(usn, pwd,factive);
	}
	
	/***********************getters****************************************/
	public SchoolMemberModel getCoordinator() { return this.coordinator; }
	public SchoolMemberModel getSupervisor() { return this.supervisor; }
	public String getNISS() { return this.niss; }
	public String getZipCode() { return this.zipCode; }
	public String getCity() { return this.city; }
	public String getStreet() { return this.street; }
	public String getStreetNB() { return this.streetNB; }
	public String getStreetBox() { return this.streetBox; }
	public String getTel() { return this.tel; }
	public String getSection() { return this.section; }
	public String getCategory() { return this.category; }
	public String getEstablishment() { return this.establishment; }
	public StageModel getStage(){ return this.stage; }
	
	/***********************setters****************************************/
	public void setCoordinator(SchoolMemberModel value) { this.coordinator = value; }
	public void setSupervisor(SchoolMemberModel value) { this.supervisor = value; }
	public void setNISS(String value) { this.niss = value; }
	public void setZipCode(String value) { this.zipCode = value; }
	public void setCity(String value) { this.city = value; }
	public void setStreet(String value) { this.street = value; }
	public void setStreetNB(String value) { this.streetNB = value; }
	public void setStreetBox(String value) { this.streetBox = value; }
	public void setTel(String value) { this.tel = value; }
	public void setSection(String value) { this.section = value; }
	public void setCategory(String value) { this.category = value; }
	public void setEstablishment(String value) { this.establishment = value; }
	
	/***********************méthodes publiques
	 * @throws Exception *****************************/
	public static boolean create(SchoolStudentModel obj) throws Exception{
		if(obj.getSupervisor() != null && obj.getCoordinator() != null && !obj.getMail().isEmpty() &&  !obj.getTel().isEmpty() && !obj.getStreet().isEmpty() && !obj.getCity().isEmpty())
			return DB_SchoolStudent.create(obj);
		else
			throw new Exception("vous avez déjà un stage ou veuillez remplir les champs vide");
	}
	/************** liste de tous les étudiants
	 * @throws Exception *************************/
	public static  Set<SchoolStudentModel> listOfALLStudent() throws Exception{
		return DB_SchoolStudent.allStudent();
	}
	
	//renvoie un objet student
	public static SchoolStudentModel student(String usn) throws Exception{
		return DB_SchoolStudent.createStudent(usn);
	}
	
	//appel  à la fonction afficher stage de l'tudiant
	public  StageModel TrainingOfStudent(SchoolStudentModel ss) throws Exception{
		return    stage.studentTraining(ss);
	}
	
	
}







