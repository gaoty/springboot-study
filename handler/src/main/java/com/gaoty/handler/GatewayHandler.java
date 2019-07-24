/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.handler;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-24 19:20
 */
public abstract class GatewayHandler {

    /**
     * 下一个handler
     */
    protected GatewayHandler nextGatewayHandler;

    /**
     * 实现的handler 处理方案 强制必须实现
     */
    public abstract void service();


    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }

    /**
     *执行下一个handler
     */
    protected void nextService() {
        if (nextGatewayHandler != null) {
            nextGatewayHandler.service();// 指向下一关黑名单
        }
    }
}