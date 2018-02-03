package com.inpowered.sample.business.service.impl;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.inpowered.sample.business.service.BaseService;

public abstract class BaseServiceImpl <E, K extends Serializable> implements BaseService<E, K> {
	
	@Override
	public void save(E entity) {
		getRepository().save(entity);
	}
	
	@Override
	public void delete(E entity) {
		getRepository().delete(entity);
	}
	
	@Override
	public E findById(K id) {
		return getRepository().findOne(id);
	}
	
	protected abstract CrudRepository<E, K> getRepository ();

}
