package com.jcohy.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient // 服务发现
@EnableFeignClients
// @EnableDistributedTransaction
public class StudentProvider19991 {

	public static void main(String[] args) {
		SpringApplication.run(StudentProvider19991.class, args);
	}

}
