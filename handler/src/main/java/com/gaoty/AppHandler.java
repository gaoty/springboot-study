/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-24 20:15
 */
@SpringBootApplication
@MapperScan("com.gaoty.mapper")
public class AppHandler {
    public static void main(String[] args) {
        SpringApplication.run(AppHandler.class);
    }
}