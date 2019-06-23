/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.order.controller;

import com.gaoty.order.convert.OrderForm2OrderDTOConverter;
import com.gaoty.order.dto.OrderDTO;
import com.gaoty.order.enums.ResultEnum;
import com.gaoty.order.exception.OrderException;
import com.gaoty.order.form.OrderForm;
import com.gaoty.order.service.OrderService;
import com.gaoty.order.utils.ResultVOUtil;
import com.gaoty.order.vo.ResultVO;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-02-23 13:28
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public ResultVO<Map<String,String>> cratee(@Valid OrderForm orderForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                bindingResult.getFieldError().getDefaultMessage());
        }

        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

    @GetMapping("/create")
    public String create(){
        System.out.println("订单服务：被前端调用，开始调用商品服务");
        String url = "http://product/product/decreaseStock1";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(" 订单服务："+result);
        return "订单服务调用商品服务，商品服务调用消息服务成功";
    }

}