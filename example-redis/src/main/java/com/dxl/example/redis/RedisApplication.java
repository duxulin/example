package com.dxl.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

/**
 * @Program RedisApplication
 * @Description
 * @Author duxl
 * @Create 2018/12/25 9:25
 */
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class);
	}
}
