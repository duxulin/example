package com.dxl.example.thread.print;

import java.util.Scanner;

/**
 * @Author: duxl
 * @Since: 2022/11/3 9:36 AM
 * @Description:
 */
public class SyncPrint {

    static int count;
    static char[] arr = {'a', 'b', 'c'};
    static volatile Integer n;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        sc.close();

        Runnable r = () -> {
            for (n = 0; n < count; n++) {
                synchronized (SyncPrint.class) {

                    System.out.println(Thread.currentThread().getName() + arr[n % arr.length]);
                }
            }
        };

        Thread t1 = new Thread(r, "t1");
        t1.start();
        Thread t2 = new Thread(r, "t2");
        t2.start();
        Thread t3 = new Thread(r, "t3");
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

}
