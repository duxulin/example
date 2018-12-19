package com.dxl.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.UUID;

/**
 * @Program KafkaApplication
 * @Description
 * @Author duxl
 * @Create 2018/11/29 13:56
 */
@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(KafkaApplication.class);
		KafkaSender kafkaSender = (KafkaSender) applicationContext.getBean("kafkaSender");
		for (int i = 0; i < 3; i++) {
			Message message = new Message();
			message.setId(System.currentTimeMillis());
			message.setMsg(UUID.randomUUID().toString());
			message.setSendTime(new Date());
			kafkaSender.send(message);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
