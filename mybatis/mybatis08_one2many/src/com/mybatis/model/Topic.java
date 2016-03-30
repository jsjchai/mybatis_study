package com.mybatis.model;

import java.util.HashSet;
import java.util.Set;

public class Topic {

	private int id;
	private String content;
	private Set<Reply> replies=new HashSet<Reply>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", content=" + content + ", replies="
				+ replies + "]";
	}
	
	
}
