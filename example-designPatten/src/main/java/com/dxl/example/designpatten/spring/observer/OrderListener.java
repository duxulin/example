package com.dxl.example.designpatten.spring.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener implements ApplicationListener<OrderCreateEvent> {
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        System.out.println(event.getSource());
        System.out.println("listener thread name:" + Thread.currentThread().getName());


    }
}
