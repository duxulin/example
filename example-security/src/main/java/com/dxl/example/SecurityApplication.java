package com.dxl.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @Program SecurityApplication
 * @Description
 * @Author duxl
 * @Create 2019/1/2 11:09
 */
@SpringBootApplication()
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class);
	}
}
