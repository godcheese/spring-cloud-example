package com.godcheese.eurekaserverslave2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author godcheese [godcheese@outlook.com]
 * @date 2020-05-16
 * @EnableEurekaServer 注解表示启用 Eureka Server，该应用为服务注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerSlave2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSlave2Application.class, args);
    }

}