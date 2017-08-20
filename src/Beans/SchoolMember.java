package Beans;

import java.util.List;

import Models.SchoolStudentModel;
import Models.StageModel;

public class SchoolMember {
	
	/**
	 * The schoolMember tel
	 */
	private String tel;
	
	/**
	 * The status of SchoolMember
	 */
	private boolean flag_coordinator;
	
	/**
	 *  The list of stage 
	 */
	private List<StageModel> listStage;
	
	/**
	 * The list of student
	 */
	private List<SchoolStudentModel> listStudent ;

	/**
	 * 
	 * @return The member tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 
	 * @param tel: The tel of members
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 
	 * @return the status of the member
	 */
	public boolean isFlag_coordinator() {
		return flag_coordinator;
	}

	/**
	 * 
	 * @param flag_coordinator: The boolean of define the status of members
	 */
	public void setFlag_coordinator(boolean flag_coordinator) {
		this.flag_coordinator = flag_coordinator;
	}

	/**
	 * 
	 * @return all stages
	 */
	public List<StageModel> getListStage() {
		return listStage;
	}

	/**
	 * 
	 * @param listStage
	 */
	public void setListStage(List<StageModel> listStage) {
		this.listStage = listStage;
	}

	public List<SchoolStudentModel> getListStudent() {
		return listStudent;
	}

	/**
	 * 
	 * @param listStudent
	 */
	public void setListStudent(List<SchoolStudentModel> listStudent) {
		this.listStudent = listStudent;
	}
	
}
