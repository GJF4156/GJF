package com.lin.lostandfound.domain;

// Generated 2017-4-20 10:53:03 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Expressthanks generated by hbm2java
 */
public class ExpressThanks implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String substance;
	private int status;
	private String userName;
	private Date leaveTime;

	public ExpressThanks() {
	}

	public ExpressThanks(String title, String substance, int status,
			String userName, Date leaveTime) {
		this.title = title;
		this.substance = substance;
		this.status = status;
		this.userName = userName;
		this.leaveTime = leaveTime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubstance() {
		return this.substance;
	}

	public void setSubstance(String substance) {
		this.substance = substance;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	@Override
	public String toString() {
		return "ExpressThanks [id=" + id + ", title=" + title + ", substance="
				+ substance + ", status=" + status + ", userName=" + userName
				+ ", leaveTime=" + leaveTime + "]";
	}

}
