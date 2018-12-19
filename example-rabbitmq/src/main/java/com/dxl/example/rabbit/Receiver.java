package com.dxl.example.rabbit;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;
import org.springframework.amqp.rabbit.support.MessagePropertiesConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
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

	static MessagePropertiesConverter messagePropertiesConverter = new DefaultMessagePropertiesConverter();

	@RabbitListener(queues = {"direct_queue"})
	public void receiveMessage(Message message, Channel channel) {


		System.out.println("queue Received: " + message);
		String s = new String(message.getBody());

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







