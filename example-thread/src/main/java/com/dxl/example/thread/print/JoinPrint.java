package com.dxl.example.thread.print;

/**
 * @author duxl
 * @date 2022/9/15 10:10
 */

public class JoinPrint {

    /**
     * 只打印一次
     * @param args
     */
    public static void main(String[] args) {
        final Thread t1 = new Thread(()->{
            System.out.println("t1");
        });

        final Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        });

        final Thread t3 = new Thread(()->{
            try {
                t2.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("t3");
        });


        t2.start();
        t3.start();
        t1.start();
    }
}
