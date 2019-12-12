package net.tf.javaee.model;

import java.util.Date;

public class User  {
	private String uid;
	private String username;
	private String password;
	private String gender;
	private String birthdate;
	private String description;
	private Date registdate;
	private String registip;
	
	public User() {
		
	}
	public User(String uid, String username, String password, String gender, String birthdate, String description,
			Date registdate, String registip) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.birthdate = birthdate;
		this.description = description;
		this.registdate = registdate;
		this.registip = registip;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getRegistdate() {
		return registdate;
	}
	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}
	public String getRegistip() {
		return registip;
	}
	public void setRegistip(String registip) {
		this.registip = registip;
	}
	
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", birthdate=" + birthdate + ", description=" + description + ", registdate=" + registdate
				+ ", registip=" + registip + "]";
	}
	
	
	
}
