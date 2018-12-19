package com.dxl.example.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Program KafkaSender
 * @Description
 * @Author duxl
 * @Create 2018/11/29 13:58
 */
@Component
@Slf4j
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private Gson gson = new GsonBuilder().create();

	public void send(Message message) {
		log.info("send message:{}", gson.toJson(message));
		kafkaTemplate.send("kafka-topic", gson.toJson(message));
	}
}
