package com.godcheese.consumer1;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author godcheese [godcheese@outlook.com]
 * @date 2020-05-22
 */
@Configuration
public class RestTemplateConfiguration {

    /**
     * 负载均衡的 RestTemplate
     *
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate lbRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 不负载均衡的 RestTemplate
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
