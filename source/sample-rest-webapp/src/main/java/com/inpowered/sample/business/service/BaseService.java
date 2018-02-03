package com.inpowered.sample.business.service;

import java.io.Serializable;

public interface BaseService<E, K extends Serializable> {
	
	public void save (E entity);
	
	public void delete (E entity);
	
	public E findById (K id);

}
