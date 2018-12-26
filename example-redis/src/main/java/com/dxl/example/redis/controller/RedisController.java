package com.dxl.example.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program RedisController
 * @Description
 * @Author duxl
 * @Create 2018/12/25 9:30
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
	@Autowired
	@Qualifier("redisTemplate")
	RedisTemplate redisTemplate;

	@RequestMapping("/delete/{key}")
	public String deleteKey(@PathVariable String key) {

		Boolean b = redisTemplate.delete(key);
		return String.valueOf(b);
	}


	@RequestMapping("/add/{key}")
	public String addKey(@PathVariable String key) {
		redisTemplate.opsForValue().set(key, "1" + key);
		return "success";
	}
}
