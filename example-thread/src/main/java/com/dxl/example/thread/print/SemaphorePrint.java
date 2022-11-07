package com.dxl.example.thread.print;

import java.util.concurrent.Semaphore;

/**
 * @author duxl
 * @date 2022/9/15 13:51
 */

public class SemaphorePrint {


    static Semaphore s1 = new Semaphore(1);
    static Semaphore s2 = new Semaphore(0);
    static Semaphore s3 = new Semaphore(0);


    public static void main(String[] args)  {
        new Thread(() -> {
            for(int i = 0 ;i < 10;i++){
                try {
                    s1.acquire();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    s2.release();
                }
            }
        }, "A").start();

        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    s2.acquire();
                    System.out.println(Thread.currentThread().getName());

                }catch (InterruptedException e){

                }finally {
                    s3.release();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    s3.acquire();
                    System.out.println(Thread.currentThread().getName());

                }catch (InterruptedException e){

                }finally {
                    s1.release();
                }
            }
        },"C").start();




    }


}
