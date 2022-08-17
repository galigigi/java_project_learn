package com.baidu.incrm.onefrontnumber.intf;

import com.baidu.incrm.onefrontnumber.app.enent.MessageInputProcessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.baidu.phecda.api", "com.baidu.incrm", "com.baidu.crm"})   // 注册为服务的注解
@EnableDiscoveryClient //  发现服务的注解
@EnableBinding(value = { MessageInputProcessor.class})
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.baidu.incrm.onefrontnumber.inf.mapper")
@ComponentScan(basePackages = {"com.baidu.crm", "com.baidu.incrm.onefrontnumber","com.baidu.phecda.api",
        "com.baidu.incrm.onefrontnumber.inf", "com.baidu.incrm.userdacdimerolefunc"})
public class OneFrontNumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneFrontNumberApplication.class, args);
    }
}
