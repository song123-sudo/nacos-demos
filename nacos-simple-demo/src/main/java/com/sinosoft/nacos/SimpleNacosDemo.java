package com.sinosoft.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/*
 *@author
 *16602  2021/10/23 15:20
 */
public class SimpleNacosDemo {
    public static void main(String[] args) throws NacosException {

//        使用nacos client远程获取nacos服务上的配置信息
//    nacos server地址
        String serverAddr = "127.0.0.1:8848";

        String dataId = "nacos-simple-demo.yaml";

        String group = "DFAULT_GROUP";

        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        //获取配置
        ConfigService configService = NacosFactory.createConfigService(properties);
        String config = configService.getConfig(dataId,group,5000);
        System.out.println(config);

        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                System.out.println(config);
            }
        });
        //不让这个程序执行结束
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
