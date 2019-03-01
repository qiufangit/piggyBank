package com.qiu.mapper;

import com.qiu.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Project:PiggyBank
 * File:com.qiu.mapper
 * Author:qiufan
 * Email :qiufan@homolo.com
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
@Repository
public interface UserMapper {
	int save(User user);
}
