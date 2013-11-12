package org.nhnnext.web;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.junit.Ignore;

@Entity
public class SignBoard {
	
	@Id
	private String email;
	
	@Column(length=12, nullable=false)
	private String password;
	
	@Column(length=8, nullable=false)
	private String name;
	
	@OneToMany(mappedBy="signBoard")
	private List<PhotoBoard> photoBoards;
	
	@OneToMany(mappedBy="signBoard")
	private List<CommentsBoard> commentsBoards;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<PhotoBoard> getPhotoBoards() {
		return photoBoards;
	}
	
	public List<CommentsBoard> getCommentsBoards() {
		return commentsBoards;
	}
	
	
}
