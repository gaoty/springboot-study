/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.proxy.service.proxy;

import com.gaoty.proxy.service.OrderService;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-08-07 09:25
 */
public class OrderServiceProxy implements OrderService {
    /**
     * 被代理对象
     */
    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void order() {
        System.out.println("日志收集开始..");
        orderService.order();
        System.out.println("日志收集结束..");

    }
}