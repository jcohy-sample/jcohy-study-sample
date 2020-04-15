package com.jcohy.rabbit.sample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcohy.rabbit.sample.model.Order;
import com.jcohy.rabbit.sample.producer.ProducerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @author jiac <a href="http://www.jcohy.com"></a>
 * @since 1.0.0 2020/04/13 2020/4/13:11:34
 * Description
 */
@Controller
public class IndexController {

    @Autowired
    private ProducerMessage producerMessage;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/a")
    @ResponseBody
    public void a() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        //Order order = new Order(UUID.randomUUID().toString(),"TEST","订单已生成");
        Order order = new Order(UUID.randomUUID().toString(), "TEST", "订单已生成");

        producerMessage.sendMsgToA(objectMapper.writeValueAsString(order));
    }
}
