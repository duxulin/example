package com.dxl.example.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Program KafkaReceiver
 * @Description
 * @Author duxl
 * @Create 2018/11/29 13:58
 */
@Component
@Slf4j
public class KafkaReceiver {
	@KafkaListener(topics = "kafka-topic")
	public void listen(ConsumerRecord<?, ?> record) {
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			record.toString();

			log.info("---------- record = {}", record);
			log.info("---------- message = {}", message);
		}
	}
}
