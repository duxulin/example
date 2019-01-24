package com.dxl.example.thread.producer$consumer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Program Two
 * @Description
 * @Author duxl
 * @Create 2019/1/7 11:27
 */
public class Two {

	private static int capacity;
	private static final int FULL = 10;
	private static final int EMPTY = 0;
	Lock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();
	private Semaphore rmutex = new Semaphore(2);

	class Producer implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.lock();
				try {
					while (capacity >= FULL) {
						notFull.await();
					}
					capacity++;
					System.out.println(Thread.currentThread().getName() + " 生产了一个面包，还剩" + capacity + "个面包");
					notEmpty.signal();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}

	class Consumer implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.lock();
				try {
					while (capacity <= EMPTY) {
						notEmpty.await();
					}
					capacity--;
					System.out.println(Thread.currentThread().getName() + " 吃了一个面包，还剩" + capacity + "个面包");
					notFull.signal();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}

	public static void main(String[] args) {
		Two two = new Two();
		new Thread(two.new Producer()).start();
		new Thread(two.new Consumer()).start();
		new Thread(two.new Consumer()).start();
		new Thread(two.new Consumer()).start();

		new Thread(two.new Producer()).start();
		new Thread(two.new Producer()).start();
	}
}
