package com.jcohy.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AccountProvider19996 {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(AccountProvider19996.class, args);
//		String userName = applicationContext.getEnvironment().getProperty("user.name");
//		String userAge = applicationContext.getEnvironment().getProperty("user.age");
//		System.err.println("user name :"+userName+"; age: "+userAge);
	}
}
