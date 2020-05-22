package com.godcheese.eurekaserverslave2;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author godcheese [godcheese@outlook.com]
 * @date 2020-05-22
 */
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 匹配 /eureka/** 禁用 csrf
        http.csrf().ignoringAntMatchers("/eureka/**");

        // 所有请求需要验证身份
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
