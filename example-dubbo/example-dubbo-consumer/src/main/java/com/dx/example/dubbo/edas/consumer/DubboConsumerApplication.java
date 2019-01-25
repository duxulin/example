package com.dx.example.dubbo.edas.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dxl.example.common.IHelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program DubboConsumerApplication
 * @Description
 * @Author duxl
 * @Create 2019/1/25 9:48
 */
@SpringBootApplication
@RestController
public class DubboConsumerApplication {

	@Reference
	private IHelloService helloService;


	@RequestMapping("/sayHello/{name}")
	public String sayHello(@PathVariable String name){
		return helloService.sayHello(name);
	}

	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class,args);
	}
}
