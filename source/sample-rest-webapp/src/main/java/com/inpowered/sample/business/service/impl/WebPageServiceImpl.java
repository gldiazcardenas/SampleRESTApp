package com.inpowered.sample.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inpowered.sample.business.service.WebPageService;
import com.inpowered.sample.domain.model.WebPage;
import com.inpowered.sample.persistence.dao.WebPageRepository;

@Service
public class WebPageServiceImpl extends BaseServiceImpl<WebPage, Long> implements WebPageService {
	
	@Autowired
	private WebPageRepository repository;

	@Override
	protected WebPageRepository getRepository() {
		return repository;
	}
	
	@Override
	public WebPage findByUrl(String url) {
		return repository.findByUrl(url);
	}

}
