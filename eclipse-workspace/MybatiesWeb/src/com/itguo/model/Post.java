package com.itguo.model;

public class Post {
	private int pid;
	private String username;
	private String title;
	private String context;
	public Post(int pid, String username, String title, String context) {
		super();
		this.pid = pid;
		this.username = username;
		this.title = title;
		this.context = context;
	}
	public Post() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "Post [pid=" + pid + ", username=" + username + ", title=" + title + ", context=" + context + "]";
	}
	
	
	
	
	

}
