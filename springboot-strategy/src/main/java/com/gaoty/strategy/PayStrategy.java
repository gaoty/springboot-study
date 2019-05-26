/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.strategy;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-05-11 16:25
 */
public interface PayStrategy {

    /**
     *  策略模式共同算法的骨架
     * @return
     */
    String toPayHtml();
}
