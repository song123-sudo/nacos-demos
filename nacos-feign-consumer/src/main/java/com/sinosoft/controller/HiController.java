package com.sinosoft.controller;

import com.sinosoft.feign.FeignHystrixInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author
 *16602  2021/10/27 14:58
 */
@RestController
@RefreshScope
public class HiController {

    @Autowired
    private FeignHystrixInter feignHystrixInter;

    @GetMapping("/hi")
    public String testhi(@RequestParam(value = "name") String name){
        return  feignHystrixInter.hi(name);
    }
}
