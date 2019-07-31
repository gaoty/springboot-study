/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.decorate.impl;

import com.gaoty.decorate.AbstractDecorator;
import com.gaoty.decorate.GatewayComponent;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-27 17:28
 */
public class LimitDecorator extends AbstractDecorator {
    public LimitDecorator(GatewayComponent gatewayComponent) {
        super(gatewayComponent);
    }

    @Override
    public void service() {
        super.service();
        System.out.println("第三步>>> 网关中新增API接口的限流..");
    }
}