/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.template.factory;

import com.gaoty.template.AbstractPayCallbackTemplate;
import com.gaoty.template.utils.SpringUtils;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-07-27 16:04
 */
@Component
public class TemplateFactory {
    public static AbstractPayCallbackTemplate getPayCallbackTemplate(String templateId) {
        AbstractPayCallbackTemplate payCallbackTemplate = (AbstractPayCallbackTemplate) SpringUtils.getBean(templateId);
        return payCallbackTemplate;
    }
}