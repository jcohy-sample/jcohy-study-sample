package com.jcohy.provider;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
@EnableDistributedTransaction
public class TeacherProvider19993 {
    public static void main(String[] args) {
        SpringApplication.run(TeacherProvider19993.class, args);
    }
}
