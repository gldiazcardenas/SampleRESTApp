package com.inpowered.sample.view.bean;

import java.io.Serializable;

public class WebPageBean implements Serializable {
	
	private static final long serialVersionUID = -5460147619993098172L;

	private String title;
	
	private String description;
	
	private String author;
	
	private String polarity;
	
	private String subjectivity;
	
	private String text;
	
	private Double polarityConfidence;
	
	private Double subjectivityConfidence;

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
