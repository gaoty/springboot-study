/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.v2;

import com.gaoty.v1.entity.UserEntity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-06-23 11:42
 */
@Configuration
@ComponentScan(value = "com.gaoty.v2", includeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class) },useDefaultFilters = false)
public class MySpringConfig {
    //@Configuration 等同于配置的spring配置文件

    @Bean
    public UserEntity userEntity(){
        return new UserEntity(10,"gaoty");
    }
}