package com.inpowered.sample.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inpowered.sample.business.service.UserService;
import com.inpowered.sample.domain.model.User;
import com.inpowered.sample.view.bean.UserBean;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("myConverterService")
	private ConversionService converterService;
	
	@PostMapping(path = "/users-create", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser (@RequestBody UserBean userBean) {
		User user = converterService.convert(userBean, User.class);
		userService.save(user);
	}

}
