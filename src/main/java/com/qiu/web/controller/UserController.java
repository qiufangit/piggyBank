package com.qiu.web.controller;

import com.qiu.entity.User;
import com.qiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Project:PiggyBank
 * File:com.qiu.web.controller
 * Author:qiufan
 * Email :qiufan@homolo.com
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	public String hello(HttpServletRequest request){
		return "hello";
	}

	@RequestMapping("/signIndex")
	public String index(HttpServletRequest request){
		return "sign";
	}


	@RequestMapping( path = "/sign" , method = RequestMethod.POST)
	public String sign(User user){
		user.setId(UUID.randomUUID().toString());
		System.out.println(user.toString());
		int save = userService.save(user);
		if (save>0){
			return "success";
		}else{
			return "faild";
		}
	}
}
