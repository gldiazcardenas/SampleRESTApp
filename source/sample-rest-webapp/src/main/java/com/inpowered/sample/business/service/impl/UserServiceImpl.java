package com.inpowered.sample.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inpowered.sample.business.service.UserService;
import com.inpowered.sample.domain.model.User;
import com.inpowered.sample.persistence.dao.UserRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	protected UserRepository getRepository() {
		return repository;
	}

}
