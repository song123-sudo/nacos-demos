package com.sinosoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author
 *16602  2021/10/27 10:29
 */
@RestController
@RefreshScope
public class TestController {
    @Value("${server.port}")
    String port;

    @Value("${name}")
    private String NAME;
    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "provider") String name) {
        return "hi " + name + " ,i am from port:" +port+"测试数据"+NAME;
    }

}
