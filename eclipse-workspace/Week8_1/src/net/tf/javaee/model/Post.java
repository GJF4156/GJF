package net.tf.javaee.model;

public class Post {
	private int postid;
	private String uid;
	private String title;
	private String content;
	
	public Post() {
		super();
	}
	
	public Post(int postid, String uid, String title, String content) {
		super();
		this.postid = postid;
		this.uid = uid;
		this.title = title;
		this.content = content;
	}

	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post [postid=" + postid + ", uid=" + uid + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
