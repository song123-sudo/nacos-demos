package com.sinosoft.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


//在接口上加 @FeignClient 注解来声明 一个Feign Client，其中 value 为 远程调用其他服务的服务名
//FeignConfig.class 为 Feign Client 的配置类，注入Retryer类的实例，这样在远程调用失败后，feign会进行重试
//使用 Spring MVC 的注解来绑定具体该服务提供的 REST 接口

//fallback 配置回调处理类，该处理类是作为 Feign 熔断器的逻辑处理类，实现FeignHystrixInter 接口
//@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = FallBack.class)

//fallbackFactory（类似于断容器）与fallback方法。
@FeignClient(value = "nacos-feign-provider",fallbackFactory = HystrixClientFactory.class)
public interface FeignHystrixInter {

    //使用 Spring MVC 的注解来绑定具体该服务提供的 REST 接口
    @GetMapping(value = "/hi")
    String hi(@RequestParam(value = "name") String name);
}
