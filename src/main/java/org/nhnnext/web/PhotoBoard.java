package org.nhnnext.web;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PhotoBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=127, nullable=true)
	private String filename;
	
	@Column(length=1023, nullable=false)
	private String article;
	
	

	@OneToMany (mappedBy="photoBoard", fetch=FetchType.EAGER)
	private List<CommentsBoard> comments;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
		System.out.println ("success: " + this.filename);
	}

	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	
	public List<CommentsBoard> getComments() {
		return this.comments;
	}
}
