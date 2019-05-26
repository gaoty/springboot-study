/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.context;

import com.gaoty.mapper.PaymentChannelMapper;
import com.gaoty.mapper.entity.PaymentChannelEntity;
import com.gaoty.strategy.PayStrategy;
import com.gaoty.utils.SpringUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-05-11 16:44
 */
@Component
public class PayContextStrategy {

    @Autowired
    private PaymentChannelMapper paymentChannelMapper;
    @Autowired
    private SpringUtils springUtils;
    public String toPayHtml(String payCode){
        //1.使用payCode参数查询数据库获取beanid
        PaymentChannelEntity paymentChannel = paymentChannelMapper.getPaymentChannel(payCode);
        if(paymentChannel==null){
            return  "没有该渠道信息";
        }
        //2.获取到bean的id之后，使用spring容器获取实例对象
        String strategyBeanId = paymentChannel.getStrategyBeanId();
        if(StringUtils.isEmpty(strategyBeanId)){
            return  "该渠道没有配置beanid";
        }
        // 3.执行该实现的方法即可.... aliPayStrategy
        PayStrategy payStrategy=SpringUtils.getBean(strategyBeanId, PayStrategy.class);
        return  payStrategy.toPayHtml();
    }
    // 优化 支付渠道存放内存中...
}