/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.decorate.impl;

import com.gaoty.decorate.GatewayComponent;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-27 17:19
 */
public class BasicComponentGateway extends GatewayComponent {
    @Override
    public void service() {
        System.out.println("第一步>>> 网关中获取基本的操作...实现");
    }
}