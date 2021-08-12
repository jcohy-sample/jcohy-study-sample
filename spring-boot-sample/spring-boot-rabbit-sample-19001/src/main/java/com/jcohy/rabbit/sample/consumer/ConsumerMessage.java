package com.jcohy.rabbit.sample.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcohy.rabbit.sample.config.RabbitConfig;
import com.jcohy.rabbit.sample.model.Order;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 2020/04/13 2020/4/13:10:31
 * Description
 */
@Component
public class ConsumerMessage {

    private final ObjectMapper objectMapper;

    public ConsumerMessage(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger log = LoggerFactory.getLogger(ConsumerMessage.class);

    /**
     * 防止重复消费，可以根据传过来的唯一ID先判断缓存数据中是否有数据
     * 1、有数据则不消费，直接应答处理
     * 2、缓存没有数据，则进行消费处理数据，处理完后手动应答
     * 3、如果消息 处理异常则，可以存入数据库中，手动处理（可以增加短信和邮件提醒功能）
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_A)
    public void handleMessage(@Payload String json, Message message, Channel channel) throws IOException {
        MessageProperties messageProperties = message.getMessageProperties();
        long deliveryTag = messageProperties.getDeliveryTag();
        try {
            Order order = objectMapper.readValue(json, Order.class);

            //模拟异常
//            int i = 1/0;
            //业务处理。

            log.info("ConsumerA 消费消息成功 deliveryTag:{} | message {} " ,deliveryTag,json  );
            //手动应答，代表消费者确认收到当前消息，语义上表示消费者成功处理了当前消息。
            channel.basicAck(deliveryTag,false);
        }catch (Exception e){
            log.error("ConsumerA 消费消息失败 deliveryTag:{} | message = {}",deliveryTag,json);
            // 处理消息失败，将消息重新放回队列。
            // 代表消费者拒绝一条或者多条消息。basicNack 算是 basicReject 的一个扩展，因为 basicReject 不能一次拒绝多条消息。
            channel.basicNack(deliveryTag, false,true);
        }
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_B)
    public void process(@Payload String json, Message message, Channel channel) throws IOException {
        MessageProperties messageProperties = message.getMessageProperties();
        long deliveryTag = messageProperties.getDeliveryTag();
        try {
            Order order = objectMapper.readValue(json, Order.class);

            //是否是重复消息
            Boolean redelivered = messageProperties.getRedelivered();

            log.info("ConsumerB 是否是重复消息:{}",redelivered);
            //模拟异常
            int i = 1/0;
            //业务处理。

            log.info("ConsumerB 消费消息成功 deliveryTag:{} | message {} " ,deliveryTag,json  );


            //手动应答，代表消费者确认收到当前消息，语义上表示消费者成功处理了当前消息。
            channel.basicAck(deliveryTag,false);
        }catch (Exception e){
            log.error("ConsumerB 消费消息失败 deliveryTag:{} | message = {}",deliveryTag,json);
            // 处理消息失败，将消息重新放回队列。
            // 代表消费者拒绝一条或者多条消息。basicNack 算是 basicReject 的一个扩展，因为 basicReject 不能一次拒绝多条消息。
            channel.basicNack(deliveryTag, false,true);
        }
    }
}
