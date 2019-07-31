/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.decorate;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-27 17:20
 */
public class AbstractDecorator extends GatewayComponent{
    protected GatewayComponent gatewayComponent;

    public AbstractDecorator(GatewayComponent gatewayComponent) {
        this.gatewayComponent = gatewayComponent;
    }
    @Override
    public void service() {
        if (gatewayComponent != null) {
            gatewayComponent.service();
        }
    }
}