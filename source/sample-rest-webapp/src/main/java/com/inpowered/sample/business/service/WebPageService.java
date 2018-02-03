package com.inpowered.sample.business.service;

import com.inpowered.sample.domain.model.WebPage;

public interface WebPageService extends BaseService<WebPage, Long> {
	
	public WebPage findByUrl (String url);
	
}
