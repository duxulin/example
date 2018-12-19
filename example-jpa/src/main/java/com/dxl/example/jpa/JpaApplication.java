package com.dxl.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Program JpaApplication
 * @Description
 * @Author duxl
 * @Create 2018/12/11 9:07
 */
@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(JpaApplication.class);
	}
}
