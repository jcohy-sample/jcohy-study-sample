package com.jcohy.sample.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jiac <a href="http://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/2 14:03
 */
@SpringBootApplication
@MapperScan("com.jcohy.sample.mybatis.mapper")
public class SpringMybatisSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisSampleApplication.class,args);
    }
}
