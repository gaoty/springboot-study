/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.v1.test;

import com.gaoty.v1.entity.UserEntity;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-06-23 11:26
 */
public class XmlTest {
    public static void main(String[] args) {
        //1.读取spring配置文件,创建IOC容器
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
            "applicationContext.xml");
        //2.从SpringIoc容器获取userEntity
        UserEntity userEntity = (UserEntity) classPathXmlApplicationContext.getBean("userEntity");
        System.out.println(userEntity.toString());
    }
}