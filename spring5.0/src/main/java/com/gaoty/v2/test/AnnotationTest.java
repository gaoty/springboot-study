/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.v2.test;

import com.gaoty.v1.entity.UserEntity;
import com.gaoty.v2.MySpringConfig;
import com.gaoty.v2.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解启动测试类
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-06-23 11:48
 */
public class AnnotationTest {
    private static  AnnotationConfigApplicationContext annotationConfigApplicationContext;

    public static void main(String[] args) {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MySpringConfig.class);
        System.out.println("spring容器加载完毕");
        UserEntity userEntity = (UserEntity) annotationConfigApplicationContext.getBean("userEntity");
        System.out.println(userEntity.toString());

        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
        System.out.println("userService:" + userService);
        System.out.println("以下为IOC容器注入成功的对象");
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }

    }

}