package Beans;

public class User {
	/**
	 * The user login
	 */
	private String usn;
	
	/**
	 * The user password
	 */
	private String pwd;
	
	/**
	 * is user active
	 */
	private boolean factive;
	
	/**
	 * The user first name
	 */
	private String f_name;
	
	/**
	 * The user last name
	 */
	private String l_name;
	
	/**
	 * The user mail
	 */
	private String mail;
	
	/**
	 * 
	 * @return the user login
	 */
	public String getUsn() {
		return usn;
	}

	/**
	 * 
	 * @param usn: set the user login
	 */
	public void setUsn(String usn) {
		this.usn = usn;
	}

	/**
	 * 
	 * @return the user password
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * 
	 * @param pwd: set the user password
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 
	 * @return if the user is active or not
	 */
	public boolean isFactive() {
		return factive;
	}

	/**
	 * 
	 * @param factive: set the user the status of user
	 */
	public void setFactive(boolean factive) {
		this.factive = factive;
	}

	/**
	 * 
	 * @return the user first name
	 */
	public String getF_name() {
		return f_name;
	}

	/**
	 * 
	 * @param f_name: set the user first name
	 */
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	/**
	 * 
	 * @return the user last name
	 */
	public String getL_name() {
		return l_name;
	}

	/**
	 * 
	 * @param l_name: set the user last name
	 */
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	/**
	 * 
	 * @return the mail of the user
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * 
	 * @param mail: set the mail of the user
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	
}
