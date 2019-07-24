/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.handler.impl;

import com.gaoty.handler.GatewayHandler;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-24 19:38
 */
@Component
public class ConversationHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第三关用户会话拦截判断....");
        nextService();
    }
}