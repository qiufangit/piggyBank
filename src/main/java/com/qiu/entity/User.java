package com.qiu.entity;

import java.io.Serializable;

/**
 * Project:PiggyBank
 * File:com.qiu.entity
 * Author:qiufan
 * Email :qiufan@homolo.com
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
public class User implements Serializable {

	private String id ;
	private String username;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "id:"+getId()+"username:"+getUsername()+",password:"+getPassword()+";";
	}
}
