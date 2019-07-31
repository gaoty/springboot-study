/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.decorate.factory;

import com.gaoty.decorate.GatewayComponent;
import com.gaoty.decorate.impl.BasicComponentGateway;
import com.gaoty.decorate.impl.LimitDecorator;
import com.gaoty.decorate.impl.LogDecorator;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-27 17:37
 */
public class FactoryGateway {
    //    public static GatewayComponent getGatewayComponent() {
    //        // 1.创建日志装饰类
    //        LogDecorator logDecorator = new LogDecorator();
    //        LimitDecorator limitDecorator = new LimitDecorator();
    //        limitDecorator.setGatewayComponent(logDecorator);
    //        // 2.创建被装饰实现类
    //        BasicComponentGateway basicComponentGateway = new BasicComponentGateway();
    //        logDecorator.setGatewayComponent(basicComponentGateway);
    //        return limitDecorator;
    //    }
    public static GatewayComponent getGatewayComponent() {
        return new LimitDecorator(new LogDecorator(new BasicComponentGateway()));
    }

    public static void main(String[] args) {
        GatewayComponent gatewayComponent = FactoryGateway.getGatewayComponent();
        gatewayComponent.service();
    }
}