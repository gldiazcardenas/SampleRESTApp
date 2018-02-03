package com.inpowered.sample.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEB_PAGE")
public class WebPage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String url;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
	private String author;
	
	@Column
	private String polarity;
	
	@Column
	private String subjectivity;
	
	@Column
	private String text;
	
	@Column
	private Double polarityConfidence;
	
	@Column
	private Double subjectivityConfidence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPolarity() {
		return polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	public String getSubjectivity() {
		return subjectivity;
	}

	public void setSubjectivity(String subjectivity) {
		this.subjectivity = subjectivity;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Double getPolarityConfidence() {
		return polarityConfidence;
	}

	public void setPolarityConfidence(Double polarityConfidence) {
		this.polarityConfidence = polarityConfidence;
	}

	public Double getSubjectivityConfidence() {
		return subjectivityConfidence;
	}

	public void setSubjectivityConfidence(Double subjectivityConfidence) {
		this.subjectivityConfidence = subjectivityConfidence;
	}

}
