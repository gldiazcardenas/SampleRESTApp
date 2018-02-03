package com.inpowered.sample.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inpowered.sample.domain.model.WebPage;

@Repository
public interface WebPageRepository extends CrudRepository<WebPage, Long> {
	
	public WebPage findByUrl (String url);

}
