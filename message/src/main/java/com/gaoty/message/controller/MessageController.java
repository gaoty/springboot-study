package com.gaoty.message.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MessageController {

	@RequestMapping("/sendMessage")
	public String sendMessage() {
		System.out.println("消息服务:被商品服务调用");
		return "";
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageController.class, args);
	}

}
