package com.itguo.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Student {
	private int stuNo;
	private String atuName;
	private int stuAge;
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getAtuName() {
		return atuName;
	}
	public void setAtuName(String atuName) {
		this.atuName = atuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", atuName=" + atuName + ", stuAge=" + stuAge + "]";
	}
	
	
	
}
