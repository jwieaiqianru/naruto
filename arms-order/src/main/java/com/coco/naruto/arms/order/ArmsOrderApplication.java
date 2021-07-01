package com.coco.naruto.arms.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.coco.naruto.arms.order.mapper")
@SpringBootApplication
public class ArmsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArmsOrderApplication.class, args);
    }

}
