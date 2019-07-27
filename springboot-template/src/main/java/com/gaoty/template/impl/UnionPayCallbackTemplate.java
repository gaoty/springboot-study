/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.template.impl;

import com.gaoty.template.AbstractPayCallbackTemplate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-27 15:53
 */
@Slf4j
@Component
public class UnionPayCallbackTemplate extends AbstractPayCallbackTemplate {
    @Override
    protected Map<String, String> verifySignature() {
        //>>>>假设一下为银联回调报文>>>>>>>>>>>>>>>>
        log.info(">>>>>第一步 解析银联数据报文.....verifySignature()");
        Map<String, String> verifySignature = new HashMap<>();
        verifySignature.put("price", "1399");
        verifySignature.put("orderDes", "充值蚂蚁课堂永久会员");
        // 支付状态为1表示为成功....
        verifySignature.put("paymentStatus", "1");
        verifySignature.put("orderNumber", "201910101011");
        // 解析报文是否成功 200 为成功..
        verifySignature.put("analysisCode", "200");
        return verifySignature;

    }

    @Override
    protected String asyncService(Map<String, String> verifySignatureMap) {
        log.info(">>>>>第三步asyncService()verifySignatureMap:{}", verifySignatureMap);
        String paymentStatus = verifySignatureMap.get("paymentStatus");
        if (paymentStatus.equals("1")) {
            String orderNumber = verifySignatureMap.get("orderNumber");
            log.info(">>>>orderNumber:{orderNumber},已经支付成功 修改订单状态为已经支付...");
        }
        return resultSuccess();

    }

    @Override
    protected String resultSuccess() {
        return "success";
    }

    @Override
    protected String resultFail() {
        return null;
    }
}