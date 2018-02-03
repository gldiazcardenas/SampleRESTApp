package com.inpowered.sample.view.bean;

import java.io.Serializable;

public class WebPageCollectBean implements Serializable {
	
	private static final long serialVersionUID = -2408406307200828543L;

	private String url;
	
	private String callbackUrl;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getCallbackUrl() {
		return callbackUrl;
	}
	
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

}
