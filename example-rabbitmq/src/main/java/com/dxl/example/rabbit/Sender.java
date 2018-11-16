package com.dxl.example.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Program Sender
 * @Description
 * @Author duxl
 * @Create 2018/11/16 11:10
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public void send(String msg) {
        System.out.println("send message [" + msg + "] at time:" + sdf.format(new Date()));
        amqpTemplate.convertAndSend("spring-boot-exchange", "topic", msg);
    }
}
