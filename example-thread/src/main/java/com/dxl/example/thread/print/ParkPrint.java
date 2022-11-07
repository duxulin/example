package com.dxl.example.thread.print;

import java.util.concurrent.locks.LockSupport;

/**
 * @author duxl
 * @date 2022/9/15 11:26
 */

public class ParkPrint {


    private static final int limit = 10;

    private static Thread t1, t2, t3;


    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(t2);
                LockSupport.park();
            }

        }, "A");

        t2 = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(t3);
            }
        }, "B");

        t3 = new Thread(() -> {

            for (int k = 0; k < 10; k++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(t1);
            }
        }, "C");

        t1.start();
        t2.start();
        t3.start();
    }

}
