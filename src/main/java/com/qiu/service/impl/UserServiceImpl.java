package com.qiu.service.impl;

import com.qiu.entity.User;
import com.qiu.mapper.UserMapper;
import com.qiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project:PiggyBank
 * File:com.qiu.service.impl
 * Author:qiufan
 * Email :qiufan@homolo.com
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
	public int save(User user) {
		return userMapper.save(user);
	}
}
