package org.nhnnext.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommentsBoard {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (length=1000, nullable=false)
	private String contents;
	
	@ManyToOne
	private PhotoBoard photoBoard;
	
	public CommentsBoard() {}
	public CommentsBoard(PhotoBoard photoBoard, String contents) {
		this.photoBoard = photoBoard;
		this.contents = contents;
	}
	public void setId (Long id) {
		this.id = id;
	}
	public Long getId () {
		return id;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getContents() {
		return contents;
	}

	public void setPhotoBoard(PhotoBoard photoBoard) {
		this.photoBoard = photoBoard;
	}
	
	public PhotoBoard getPhotoBoard() {
		return photoBoard;
	}
	
	
	
}
