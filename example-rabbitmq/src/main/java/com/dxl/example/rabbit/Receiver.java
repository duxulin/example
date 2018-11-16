package com.dxl.example.rabbit;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @Program Receiver
 * @Description
 * @Author duxl
 * @Create 2018/11/15 17:05
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received: " + message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
