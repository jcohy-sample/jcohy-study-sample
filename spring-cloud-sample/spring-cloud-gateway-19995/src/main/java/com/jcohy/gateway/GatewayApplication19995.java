package com.jcohy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

/**
 * Copyright: Copyright (c) 2019http://www.jcohy.com
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/10 15:33
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/10      jiac           v1.0.0               修改原因
 */


@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication19995 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication19995.class,args);
    }


    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }
}
