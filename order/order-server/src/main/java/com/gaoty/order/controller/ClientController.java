/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.order.controller;

import com.gaoty.product.client.ProductClient;
import com.gaoty.product.common.DecreaseStockInput;
import com.gaoty.product.common.ProductInfoOutput;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-02-23 14:42
 */
@RestController
public class ClientController {

    @Autowired
    private ProductClient productClient;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
////    @Autowired
////    private RestTemplate restTemplate;
//
//    @GetMapping("/getProductMsg")
//    public String getProductMsg(){
//        //1.第一种方式(直接使用restTemplate，url写死)
////        RestTemplate restTemplate = new RestTemplate();
////        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);
//
//        //2.第二种方式（利用loadBalancerClient通用应用名获取url，再使用restTemplate）
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s/msg",serviceInstance.getHost(),serviceInstance.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url,String.class);
//
//        //3.第三种方式（利用@LoadBalanced,可在restTemplate里使用应用名字）
////        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
//        return response;

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("164103465734242707"));
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
            productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("157875196366160022",2)));
            return "ok";
    }
}