package com.coco.naruto.arms.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.coco.naruto.arms.user.mapper")
@SpringBootApplication
public class ArmsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArmsUserApplication.class, args);
    }

}
