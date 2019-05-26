package com.gaoty.controller;

import com.gaoty.context.PayContextStrategy;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: PayController
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/721:31
 */
@RestController
public class PayController {
    @Autowired
    private PayContextStrategy payContextStrategy;
    @RequestMapping("/toPayHtml")
    public  String toPayHtml(String payCode){
        if(StringUtils.isEmpty(payCode)){
            return "渠道code不能为空!";
        }
        return payContextStrategy.toPayHtml(payCode);
    }
}
