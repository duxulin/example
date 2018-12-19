package com.dxl.example.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Program Recever2
 * @Description
 * @Author duxl
 * @Create 2018/11/16 13:21
 */
@Component

public class Recever2 {

	//@RabbitListener(queues = "fanout_queue")
	public void receiveMessage(Message msg) {
		System.out.println("Receive2:" + msg);
	}

}
