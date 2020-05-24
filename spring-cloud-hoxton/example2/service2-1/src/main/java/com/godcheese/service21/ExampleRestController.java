package com.godcheese.service21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/")
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> entity = new HashMap<>(4);
        entity.put("timestamp", System.currentTimeMillis());
        entity.put("code", System.currentTimeMillis());
        entity.put("message", "success");
        Map<String, Object> data = new HashMap<>(3);
        data.put("port", serverProperties.getPort());
        data.put("index", "index");
        data.put("service", "service2-1");
        entity.put("data", data);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @RequestMapping("/example")
    public ResponseEntity<Map<String, Object>> example() {
        Map<String, Object> entity = new HashMap<>(4);
        entity.put("timestamp", System.currentTimeMillis());
        entity.put("code", System.currentTimeMillis());
        entity.put("message", "success");
        Map<String, Object> data = new HashMap<>(3);
        data.put("port", serverProperties.getPort());
        data.put("example", "example");
        data.put("service", "service2-1");
        entity.put("data", data);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

}
