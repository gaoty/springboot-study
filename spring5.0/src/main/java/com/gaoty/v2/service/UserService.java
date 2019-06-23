/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.v2.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-06-23 12:13
 */
@Service
@Lazy(true)
public class UserService {
    public UserService() {
        System.out.println("UserService无参数构造被加载...");
    }
}