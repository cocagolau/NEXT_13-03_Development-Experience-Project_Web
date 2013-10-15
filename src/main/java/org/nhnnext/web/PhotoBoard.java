package org.nhnnext.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhotoBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=127, nullable=true)
	private String filename;
	
	@Column(length=1023, nullable=false)
	private String article;

	
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
}
