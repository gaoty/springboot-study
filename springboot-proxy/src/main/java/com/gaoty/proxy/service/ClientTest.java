/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.proxy.service;

import com.gaoty.proxy.service.impl.OrderServiceImpl;
import com.gaoty.proxy.service.proxy.OrderServiceImplProxy;
import com.gaoty.proxy.service.proxy.OrderServiceProxy;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-08-07 09:28
 */
public class ClientTest {
    public static void main(String[] args) {
        OrderServiceProxy orderServiceProxy = new OrderServiceProxy(new OrderServiceImpl());
        orderServiceProxy.order();
        OrderServiceImplProxy orderServiceImplProxy = new OrderServiceImplProxy();
        orderServiceImplProxy.order();
    }
}