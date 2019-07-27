/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.template.controller;

import com.gaoty.template.AbstractPayCallbackTemplate;
import com.gaoty.template.factory.TemplateFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-27 16:11
 */
@RestController
public class TemplateController {
    @RequestMapping("/asyncCallBack")
    public String asyncCallBack(String templateId) {
        AbstractPayCallbackTemplate payCallbackTemplate = TemplateFactory.getPayCallbackTemplate(templateId);
        return payCallbackTemplate.asyncCallBack();
    }
}