/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.controller;

import com.gaoty.handler.GatewayHandler;
import com.gaoty.service.GatewayHandlerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-24 20:04
 */
@RestController
public class HandlerController {
    @Autowired
    private GatewayHandlerService gatewayHandlerService;

    @RequestMapping("/client")
    public String client() {
        //        GatewayHandler gatewayHandler = FactoryHandler.getGatewayHandler();
        //        gatewayHandler.service();
        GatewayHandler firstGatewayHandler = gatewayHandlerService.getFirstGatewayHandler();
        firstGatewayHandler.service();
        return "success";
    }
}