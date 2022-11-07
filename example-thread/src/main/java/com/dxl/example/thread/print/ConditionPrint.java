package com.dxl.example.thread.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author duxl
 * @date 2022/9/15 10:32
 */

public class ConditionPrint {


    private static Lock lock = new ReentrantLock(false);
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();


    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                lock.lock();
                try {
                    System.out.print("a");
                    b.signal();
                    if(i !=9) { // 最后一次循环的时候不等待,直接退出,促使程序终止
                        a.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }

        },"a").start();

        new Thread(()->{
            for(int i = 0;i<10;i++){
                lock.lock();
                try {
                    System.out.print("b");
                    c.signal();
                    if(i !=9) {
                        b.await();
                    }
                }catch (InterruptedException e){

                }finally {
                    lock.unlock();
                }
            }
        },"b").start();

        new Thread(()->{
            for(int i = 0;i<10;i++){
                lock.lock();
                try {
                    System.out.println("c");
                    a.signal();
                    if(i !=9) {
                        c.await();
                    }
                }catch (InterruptedException e){

                }finally {
                    lock.unlock();
                }
            }
        },"c").start();
    }
}
