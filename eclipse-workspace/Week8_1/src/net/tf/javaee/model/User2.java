package net.tf.javaee.model;

import java.util.Date;
import java.util.List;

public class User2  {
	private String uid;
	private String username;
	private List<Post> postlist;
	public User2() {
		
	}
	
	
	public User2(String uid, String username, String password, String gender, String birthdate, String description,
			Date registdate, String registip, List<Post> postlist) {
		super();
		this.uid = uid;
		this.username = username;
		
		this.postlist = postlist;
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
	
	public List<Post> getPostlist() {
		return postlist;
	}
	public void setPostlist(List<Post> postlist) {
		this.postlist = postlist;
	}


	@Override
	public String toString() {
		return "User2 [uid=" + uid + ", username=" + username + ", postlist=" + postlist + "]";
	}
	
	
	
	
}
