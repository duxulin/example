package com.dxl.example.rabbit;

import com.dxl.example.netty.serializer.KryoSerializer;
import org.springframework.amqp.core.*;
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
    //    private AmqpTemplate amqpTemplate;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @RequestMapping("/send")
    @ResponseBody
    public String send(String name, int age) {
        Person person = new Person();
        person.setAge(age);
        person.setName(name);

        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] serializer = kryoSerializer.serializer(person);

        String correlationId = UUID.randomUUID().toString();
        CorrelationData correlationData = new CorrelationData(correlationId);

        System.out.println("correlationDate:" + correlationData);
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setCorrelationId(correlationId);
        Message message = new Message(serializer, messageProperties);
        amqpTemplate.convertAndSend("direct_exchange", "direct_routing_key", message, correlationData);
        return "success";
    }
}
