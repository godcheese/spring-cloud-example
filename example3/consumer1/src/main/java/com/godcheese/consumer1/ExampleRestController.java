package com.godcheese.consumer1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author godcheese [godcheese@outlook.com]
 * @date 2020-05-22
 */
@RestController
public class ExampleRestController {

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private RestTemplate lbRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> entity = new HashMap<>(4);
        entity.put("timestamp", System.currentTimeMillis());
        entity.put("code", System.currentTimeMillis());
        entity.put("message", "success");
        Map<String, Object> data = new HashMap<>(3);
        data.put("port", serverProperties.getPort());
        data.put("index", "index");
        data.put("service", "consumer1");
        entity.put("data", data);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    /**
     * 负载均衡的 RestTemplate 请求，可以用服务名请求
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/lb_example")
    public Map<String, Object> lbExample() {
        // 请求 service2
        return lbRestTemplate.getForObject("http://service2/", Map.class);
    }

    /**
     * 不负载均衡的 RestTemplate 请求，需要用 url 请求
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/example")
    public Map<String, Object> example() {
        // 请求 service1
        return restTemplate.getForObject("http://localhost:8081/", Map.class);
    }
}
