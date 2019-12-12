package com.itguo.dao;

public class UserBean {
	private String uid;
	private String username;
	private String password;
	private String gender;
	private String birthdate;
	private String description;
	public UserBean() {
		
	}
	
	
	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public UserBean(String uid, String username, String password, String gender, String birthdate, String description) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.birthdate = birthdate;
		this.description = description;
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
	
}
