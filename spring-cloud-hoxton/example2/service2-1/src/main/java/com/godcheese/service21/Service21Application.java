package com.godcheese.service21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author godcheese [godcheese@outlook.com]
 * @date 2020-05-16
 * @EnableEurekaClient 注解表示启用 Eureka Client，该应用需向服务注册中心注册
 */
@EnableEurekaClient
@SpringBootApplication
public class Service21Application {

    public static void main(String[] args) {
        SpringApplication.run(Service21Application.class, args);
    }

}