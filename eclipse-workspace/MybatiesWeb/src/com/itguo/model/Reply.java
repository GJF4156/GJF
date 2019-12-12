package com.itguo.model;

public class Reply {
	private int rid;
	private String title;
	private String context;
	private String username;
	private String replyContext;
	public Reply(int rid, String title, String context, String username, String replyContext) {
		super();
		this.rid = rid;
		this.title = title;
		this.context = context;
		this.username = username;
		this.replyContext = replyContext;
	}
	public Reply() {
		super();
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReplyContext() {
		return replyContext;
	}
	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", title=" + title + ", context=" + context + ", username=" + username
				+ ", replyContext=" + replyContext + "]";
	}
	
	

}
