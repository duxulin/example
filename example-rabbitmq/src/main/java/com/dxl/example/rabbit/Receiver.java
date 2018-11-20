package com.dxl.example.rabbit;

import com.dxl.example.netty.serializer.KryoSerializer;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Program Receiver
 * @Description
 * @Author duxl
 * @Create 2018/11/15 17:05
 */
@Component
public class Receiver {
    private static Logger log = LoggerFactory.getLogger(Receiver.class);

    public static Set<Long> failureMsg = new HashSet<>();

    @RabbitListener(queues = {"direct_queue"})
    public void receiveMessage(Message message, Channel channel) {
        KryoSerializer kryoSerializer = new KryoSerializer();
        Person deserializer = kryoSerializer.deserializer(message.getBody());
        log.info("age:{}", deserializer.getAge());
        log.info("name:{}", deserializer.getName());

        //System.out.println("queue Received: " + message);
        //String s = new String(message.getBody());

        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        String correlationId = message.getMessageProperties().getCorrelationId();
        log.info("deliveryTag = " + deliveryTag);
        log.info("correlationId = " + correlationId);
        try {
            //System.out.println(s);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            if (failureMsg.contains(deliveryTag)) {
                failureMsg.remove(deliveryTag);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            try {
                if (!failureMsg.contains(deliveryTag)) {
                    log.info("第一次处理失败，重新进入队列");
                    channel.basicNack(deliveryTag, false, true);
                    failureMsg.add(deliveryTag);
                } else {
                    log.info("超过2次处理失败，不进入队列");
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
                }
            } catch (IOException ex) {

            }
        }
    }

}







