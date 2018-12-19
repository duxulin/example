package com.dxl.example.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

/**
 * @Program RabbitConfig
 * @Description
 * @Author duxl
 * @Create 2018/11/16 14:19
 */
@Configuration
public class RabbitConfig {
	private static final Logger log = LoggerFactory.getLogger(RabbitConfig.class);

	@Resource
	private RabbitTemplate rabbitTemplate;


	@Bean
	public AmqpTemplate amqpTemplate() {
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.setEncoding("UTF-8");
		rabbitTemplate.setMandatory(true);
		rabbitTemplate.setMessagePropertiesConverter(new DefaultMessagePropertiesConverter());

		rabbitTemplate.setReturnCallback(((message, replyCode, replyText, exchange, routingKey) -> {
			String correlationId = message.getMessageProperties().getCorrelationId();
			log.info("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", message, replyCode, replyText, exchange, routingKey);
		}));


		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			log.info("correlationData:{}", correlationData);
			log.info("确认结果 :{}", ack);

			log.info("失败原因：{}", cause);
		});
		return rabbitTemplate;
	}

	@Bean("directExchange")
	public DirectExchange directExchange() {
//        return ExchangeBuilder.directExchange("direct_exchange").durable(true).build();
		return new DirectExchange("direct_exchange");
	}


	@Bean("directQueue")
	public Queue directQueue() {
		//return QueueBuilder.durable("direct_queue").build();
		return new Queue("direct_queue");
	}

	@Bean
	public Binding directBinding(@Qualifier("directQueue") Queue queue, @Qualifier("directExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("direct_routing_key");
	}


	//  fanout

	@Bean("fanoutExchange")
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanout_exchange");
	}

	@Bean("fanoutQueue")
	Queue fanoutQueue() {
		return new Queue("fanout_queue");
	}

	@Bean
	Binding fanoutBinding(@Qualifier("fanoutQueue") Queue queue, @Qualifier("fanoutExchange") FanoutExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange);
	}

}
