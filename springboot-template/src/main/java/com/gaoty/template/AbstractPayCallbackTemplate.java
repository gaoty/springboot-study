/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.template;

import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-27 15:14
 */
@Slf4j
@Component
public abstract class AbstractPayCallbackTemplate {
    /**
     * 异步回调业务
     *
     * @return
     */
    public String asyncCallBack() {
        // 1. 支付回调验证参数
        Map<String, String> verifySignatureMap = verifySignature();
        // 2. 参数验证成功，写入日志中..
        payLog(verifySignatureMap);
        String analysisCode = verifySignatureMap.get("analysisCode");
        if (!analysisCode.equals("200")) {
            return resultFail();
        }
        // 3. 执行回调异步相关逻辑
        return asyncService(verifySignatureMap);

    }


    /**
     * 支付回调验证参数
     *
     * @return
     */
    protected abstract Map<String, String> verifySignature();

    /**
     * 使用多线程异步写入日志
     *
     * @param verifySignatureMap
     */
    @Async
    private void payLog(Map<String, String> verifySignatureMap) {
        log.info(">>>>>>>>>>第二步 写入payLog........");
    }

    /**
     * 每个子类需要实现 实现业务解析操作
     *
     * @return
     */
    protected abstract String asyncService(Map<String, String> verifySignatureMap);

    /**
     * 异步返回结果..
     *
     * @return
     */
    protected abstract String resultSuccess();

    /**
     * 异步返回失败
     *
     * @return
     */
    protected abstract String resultFail();
}