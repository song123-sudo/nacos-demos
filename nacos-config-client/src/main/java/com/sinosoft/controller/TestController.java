package com.sinosoft.controller;

/*
 *@author
 *16602  2021/10/26 16:40
 */


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${test.name}")
    private String name;
    @Value("${test.age}")
    private int age;

    @RequestMapping("/test")
    public String test(){
        return "name:" + name + " / " + "age" + age;
    }
}
