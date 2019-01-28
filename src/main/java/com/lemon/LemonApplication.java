package com.lemon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.lemon.dao"})
public class LemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LemonApplication.class, args);
    }

}

