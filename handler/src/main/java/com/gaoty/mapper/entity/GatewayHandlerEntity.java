/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.mapper.entity;

import lombok.Data;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-24 19:58
 */
@Data
public class GatewayHandlerEntity {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * handler名称
     */
    private String handlerName;
    /**
     * handler主键id
     */
    private String handlerId;
    /**
     * 下一个handler
     */
    private String nextHandlerId;
}