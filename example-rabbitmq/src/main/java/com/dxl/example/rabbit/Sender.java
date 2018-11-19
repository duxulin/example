package com.dxl.example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @Program Sender
 * @Description
 * @Author duxl
 * @Create 2018/11/16 11:10
 */
@Controller("/mq")
public class Sender {

    @Autowired
    private RabbitTemplate amqpTemplate;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @RequestMapping("/send")
    @ResponseBody
    public String send(int x) {
        //System.out.println("send message [" + msg + "] at time:" + sdf.format(new Date()));
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("correlationDate:" + correlationData);
        //amqpTemplate.convertAndSend("spring-boot-exchange", "topic", x);
        amqpTemplate.convertAndSend("direct_exchange", "direct_routing_key", x, correlationData);
        //amqpTemplate.con
        return "success";
    }
}
