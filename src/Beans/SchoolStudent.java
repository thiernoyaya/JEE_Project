package Beans;

import Models.SchoolMemberModel;
import Models.StageModel;

public class SchoolStudent {
	/**
	 *  The SchoolMember is a coordinator
	 */
	private SchoolMemberModel coordinator;
	
	/**
	 * The SchoolMemeber is a supervisor
	 */
	private SchoolMemberModel supervisor;
	
	/**
	 * The Stage
	 */
	private StageModel stage;
	
	/**
	 * the national registre 
	 */
	private String niss;
	
	/**
	 *  The zipCode
	 */
	private String zipCode;
	
	/**
	 * The name of city
	 */
	private String city;
	
	/**
	 * The name of street
	 */
	private String street;
	
	/**
	 * The number of street
	 */
	private String streetNB;
	
	/**
	 * The number of street box
	 */
	private String streetBox;
	
	/**
	 * The student tel
	 */
	private String tel;
	
	/**
	 * The section of student
	 */
	private String section;
	
	/**
	 * The category of student
	 */
	private String category;
	
	/**
	 * The establishement of student
	 */
	private String establishment;

	public SchoolMemberModel getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(SchoolMemberModel coordinator) {
		this.coordinator = coordinator;
	}

	public SchoolMemberModel getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(SchoolMemberModel supervisor) {
		this.supervisor = supervisor;
	}

	public StageModel getStage() {
		return stage;
	}

	public void setStage(StageModel stage) {
		this.stage = stage;
	}

	public String getNiss() {
		return niss;
	}

	public void setNiss(String niss) {
		this.niss = niss;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNB() {
		return streetNB;
	}

	public void setStreetNB(String streetNB) {
		this.streetNB = streetNB;
	}

	public String getStreetBox() {
		return streetBox;
	}

	public void setStreetBox(String streetBox) {
		this.streetBox = streetBox;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEstablishment() {
		return establishment;
	}

	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}

}
