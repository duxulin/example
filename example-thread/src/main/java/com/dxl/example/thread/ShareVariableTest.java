package com.dxl.example.thread;

import java.util.concurrent.ThreadPoolExecutor;

public class ShareVariableTest {

    public static void main(String[] args) throws InterruptedException {
//		ShareVariableTest shareVariableTest = new ShareVariableTest();
//		shareVariableTest.wait();
//		System.out.println(1);

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
    }
}

class ShareVariableRunable implements Runnable {
    int num = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + num);
        }
    }
}
