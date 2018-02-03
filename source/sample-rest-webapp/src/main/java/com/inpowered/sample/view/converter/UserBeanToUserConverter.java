package com.inpowered.sample.view.converter;

import org.springframework.core.convert.converter.Converter;

import com.inpowered.sample.domain.model.User;
import com.inpowered.sample.view.bean.UserBean;

public class UserBeanToUserConverter implements Converter<UserBean, User> {

	@Override
	public User convert(UserBean source) {
		User user = new User();
		user.setId(source.getId());
		user.setName(source.getName());
		user.setPassword(source.getPassword());
		user.setUsername(source.getUsername());
		return user;
	}

}
