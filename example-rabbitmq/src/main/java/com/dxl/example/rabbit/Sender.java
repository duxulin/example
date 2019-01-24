package com.dxl.example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
public class Sender{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	//    private AmqpTemplate amqpTemplate;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@RequestMapping("/send")
	@ResponseBody
	public String send(@Validated Person person) {


		String correlationId = UUID.randomUUID().toString();
		//correlationId必须设置到messageProperties中，否则消费则无法获取到；
		//正确做法
		rabbitTemplate.convertAndSend("direct_exchange", "direct_routing_key", person, message -> {
			message.getMessageProperties().setCorrelationId(correlationId);
			return message;
		});
		//错误做法 消费者收不到correlationId
		//rabbitTemplate.convertAndSend("direct_exchange","direct_routing_key",person,new CorrelationData(correlationId));
		return "success";
	}
}
