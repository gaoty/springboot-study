/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.handler.factory;

import com.gaoty.handler.GatewayHandler;
import com.gaoty.handler.impl.BlacklistHandler;
import com.gaoty.handler.impl.ConversationHandler;
import com.gaoty.handler.impl.CurrentLimitHandler;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-24 19:40
 */
public class FactoryHandler {
    public static GatewayHandler getGatewayHandler() {
        GatewayHandler gatewayHandler1 = new CurrentLimitHandler();
        GatewayHandler gatewayHandler2 = new BlacklistHandler();
        GatewayHandler gatewayHandler3 = new ConversationHandler();
        gatewayHandler1.setNextGatewayHandler(gatewayHandler2);
        gatewayHandler2.setNextGatewayHandler(gatewayHandler3);
        return gatewayHandler1;
    }
}