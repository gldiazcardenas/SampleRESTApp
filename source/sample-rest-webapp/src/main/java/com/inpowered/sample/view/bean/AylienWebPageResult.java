package com.inpowered.sample.view.bean;

public class AylienWebPageResult {
	
	private String polarity;
	
	private String subjectivity;
	
	private Double polarityConfidence;
	
	private Double subjectivityConfidence;

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
