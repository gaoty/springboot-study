/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.service;

import com.gaoty.handler.GatewayHandler;
import com.gaoty.mapper.GatewayHandlerMapper;
import com.gaoty.mapper.entity.GatewayHandlerEntity;
import com.gaoty.utils.SpringUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-24 19:56
 */
@Service
public class GatewayHandlerService {
    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;
    private GatewayHandler firstGatewayHandler;

    /**
     * 获取数据库第一个handeler封装
     *
     * @return
     */
    public GatewayHandler getFirstGatewayHandler() {
        if (firstGatewayHandler != null) {
            return firstGatewayHandler;
        }
        // 1.从数据库中查询地址hanlder
        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandler();
        if (firstGatewayHandlerEntity == null) {
            return null;
        }
        // 2.获取springboot注入容器id
        String handlerId = firstGatewayHandlerEntity.getHandlerId();
        GatewayHandler firstGatewayHandler = SpringUtils.getBean(handlerId, GatewayHandler.class);
        // 3.获取下一个handler容器beanid
        String nextHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
        // 4. 记录当前循环hanlder对象
        GatewayHandler tempGatewayHandler = firstGatewayHandler;
        while (!StringUtils.isEmpty(nextHandlerId)) {
            // 5.从springboot容器获取下一个handerl对象
            GatewayHandler nextGatewayHandler = SpringUtils.getBean(nextHandlerId, GatewayHandler.class);
            tempGatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            // 6.设置下一个nextHandlerId
            GatewayHandlerEntity nextGatewayHandlerEntity = gatewayHandlerMapper.getByHandler(nextHandlerId);
            if (nextGatewayHandlerEntity == null) {
                break;
            }
            nextHandlerId = nextGatewayHandlerEntity.getNextHandlerId();
            tempGatewayHandler = nextGatewayHandler;
        }
        this.firstGatewayHandler = firstGatewayHandler;
        return firstGatewayHandler;
    }
}