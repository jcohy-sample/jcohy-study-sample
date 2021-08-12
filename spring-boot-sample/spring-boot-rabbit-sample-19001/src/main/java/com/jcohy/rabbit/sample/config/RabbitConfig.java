package com.jcohy.rabbit.sample.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 2020/04/13 2020/4/13:10:25
 * Description
 */
@Configuration
public class RabbitConfig {


    public static final String EXCHANGE_A = "my_mq_exchange_A";
    public static final String EXCHANGE_B = "my_mq_exchange_B";
    public static final String EXCHANGE_C = "my_mq_exchange_C";

    public static final String QUEUE_A="QUEUE_A";
    public static final String QUEUE_B="QUEUE_B";
    public static final String QUEUE_C="QUEUE_C";


    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     * FanoutExchange: 将消息分发到所有的绑定队列，无 routingkey的概念
     * HeadersExchange: 通过添加属性key - value匹配
     * DirectExchange: 按照routingkey分发到指定队列
     * TopicExchange : 多关键字匹配
     * @return
     */
    @Bean
    public DirectExchange defaultExchange(){
        return new DirectExchange(EXCHANGE_A,true,false);
    }

    @Bean
    public DirectExchange defaultExchangeB(){
        return new DirectExchange(EXCHANGE_B,true,false);
    }

    @Bean
    public Queue queueA(){
        // 队列持久化
        return  new Queue(QUEUE_A,true);
    }

    @Bean
    public Queue queueB(){
        // 队列持久化
        return  new Queue(QUEUE_B,true);
    }

    /**
     * 一个交换机可以绑定多个消息队列，也就是消息通过一个交换机,可以分发到不同的队列当中去。
     * @return
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind( queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
    }

    @Bean
    public Binding bindingB(){
        return BindingBuilder.bind( queueB()).to(defaultExchangeB()).with(RabbitConfig.ROUTINGKEY_B);
    }
}
