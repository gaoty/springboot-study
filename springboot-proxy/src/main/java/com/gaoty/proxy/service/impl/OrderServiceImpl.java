/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.proxy.service.impl;

import com.gaoty.proxy.service.OrderService;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-08-07 09:24
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void order() {
        System.out.println("修改数据库订单操作..");
    }
}