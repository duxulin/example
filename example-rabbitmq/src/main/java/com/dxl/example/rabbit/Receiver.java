package com.dxl.example.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Program Receiver
 * @Description
 * @Author duxl
 * @Create 2018/11/15 17:05
 */
@Component
public class Receiver {


    @RabbitListener(queues = {"fanout_queue"})
    public void receiveMessage(Message message, Channel channel) {
        System.out.println("queue Received: " + message);
        String s = new String(message.getBody());
        try {
            if ("ok".equals(s)) {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            } else {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}







