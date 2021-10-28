package com.sinosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author
 *16602  2021/10/23 13:39
 */
@RestController
@RefreshScope
public class TestController {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Value("${testurl}")
    private  String testurl;
    @GetMapping(value = "test")
    public String test(){
        System.out.println(applicationContext.getEnvironment().getProperty(testurl));
        return testurl;
    }
}
