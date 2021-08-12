package com.jcohy.rabbit.sample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcohy.rabbit.sample.callback.RabbitCallback;
import com.jcohy.rabbit.sample.model.Order;
import com.jcohy.rabbit.sample.producer.ProducerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 2020/04/13 2020/4/13:11:34
 * Description
 */
@Controller
public class IndexController implements RabbitCallback {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private ProducerMessage producerMessage;

    private String message;

    public IndexController(ProducerMessage producerMessage) {
        this.producerMessage = producerMessage;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/a")
    @ResponseBody
    public Callable<String> a() throws JsonProcessingException {

        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {

                ObjectMapper objectMapper = new ObjectMapper();

                //Order order = new Order(UUID.randomUUID().toString(),"TEST","订单已生成");
                Order order = new Order(UUID.randomUUID().toString(), "TEST", "订单已生成");
                message = null;
                logger.info("开始发送消息");
                producerMessage.sendMsgToA(objectMapper.writeValueAsString(order), IndexController.this);

                logger.info("发送消息之前 message:{}",message);
                for(;;){
                    if (message != null){
                        logger.info("发送消息之后 message:{}",message);
                        break;
                    }
                }

                return message;
            }
        };
        return result;
    }

    @Override
    public void returnCallBack(String message) {
        this.message = message;
    }
}
