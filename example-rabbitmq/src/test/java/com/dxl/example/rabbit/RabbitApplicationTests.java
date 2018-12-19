package com.dxl.example.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Program RabbitApplicationTests
 * @Description
 * @Author duxl
 * @Create 2018/11/15 17:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			String msg = "aba";
			System.out.println("send message [" + msg + "] at time:" + sdf.format(new Date()));
			rabbitTemplate.convertAndSend("direct-exchange", "direct", msg);

		}
	}


	@Test
	public void run() {
		System.out.println("sending....");
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend("direct_exchange", "direct_routing_key", "ok", correlationData);
		rabbitTemplate.convertAndSend("direct_exchange", "direct_routing_key", "no", correlationData);
	}
}
