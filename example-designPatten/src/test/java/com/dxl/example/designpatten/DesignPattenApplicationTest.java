package com.dxl.example.designpatten;

import com.dxl.example.designpatten.spring.observer.OrderCreateEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DesignPattenApplication.class)
public class DesignPattenApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test1() {
        OrderCreateEvent orderEvent = new OrderCreateEvent(String.valueOf("orderEvent"));
        applicationContext.publishEvent(orderEvent);
        System.out.println("publish thread name:" + Thread.currentThread().getName());

    }
}
