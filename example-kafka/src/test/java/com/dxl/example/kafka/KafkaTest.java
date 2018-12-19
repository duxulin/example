package com.dxl.example.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

/**
 * @Program KafkaTest
 * @Description
 * @Author duxl
 * @Create 2018/11/29 14:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {
	@Autowired
	KafkaSender kafkaSender;

	@Test
	public void aaa() {
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
