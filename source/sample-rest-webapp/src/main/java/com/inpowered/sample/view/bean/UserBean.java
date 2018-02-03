package com.inpowered.sample.view.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = -2408406307200828543L;

	private Long id;
	
	private String username;
	
	private String name;
	
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
