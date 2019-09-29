package com.dxl.example.designpatten;

import com.dxl.example.designpatten.spring.observer.OrderCreateEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Program DesignPattenApplication
 * @Description
 * @Author duxl
 * @Create 2018/12/14 9:16
 */
@SpringBootApplication
public class DesignPattenApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DesignPattenApplication.class);


        OrderCreateEvent a_order_is_create = new OrderCreateEvent("a order is create");
//		run.publishEvent(a_order_is_create);
//		System.out.println("publish thread name:"+Thread.currentThread().getName());


	}
}
