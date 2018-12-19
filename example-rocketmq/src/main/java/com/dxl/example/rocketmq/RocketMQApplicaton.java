package com.dxl.example.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Program RocketMQApplicaton
 * @Description
 * @Author duxl
 * @Create 2018/11/29 9:47
 */
@SpringBootApplication
public class RocketMQApplicaton {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RocketMQApplicaton.class);

	}
}
