package com.dx.example.dubbo.edas.producer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @Program DubboProducerApplication
 * @Description
 * @Author duxl
 * @Create 2019/1/25 9:51
 */
@SpringBootApplication
@EnableDubbo
public class DubboProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProducerApplication.class,args);
	}

}
