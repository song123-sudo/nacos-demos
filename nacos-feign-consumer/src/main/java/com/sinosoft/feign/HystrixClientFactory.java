package com.sinosoft.feign;

/*
 *@author
 *16602  2021/10/27 14:55
 */
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //注入Spring 容器中
public class HystrixClientFactory implements FallbackFactory<FeignHystrixInter> {

    private static final Logger logger = LoggerFactory.getLogger(HystrixClientFactory.class);

    @Override
    public FeignHystrixInter create(Throwable cause) {
        //一进入异常就能知道什么异常
        HystrixClientFactory.logger.info("fallback; exception was: {}", cause.toString());
        HystrixClientFactory.logger.info("fallback; reason was: {}", cause.getMessage());
        return new UserFeignClientWithFactory() {
            @Override
            public String hi(String name) {
                return "我有两把枪，一把叫射，一把叫啊";
            }
        };
    }
}

