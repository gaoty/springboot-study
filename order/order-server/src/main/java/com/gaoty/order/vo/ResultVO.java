/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.order.vo;

import lombok.Data;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-02-23 14:24
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}