package com.gaoty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gaoty.mapper")
public class SpringbootStrategyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStrategyApplication.class, args);
    }

}
