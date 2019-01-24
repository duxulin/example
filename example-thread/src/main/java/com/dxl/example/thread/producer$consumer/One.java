package com.dxl.example.thread.producer$consumer;

/**
 * @Program One
 * @Description
 * @Author duxl
 * @Create 2019/1/7 10:58
 */
public class One {

	public static int capacity;
	public static final int FULL = 10;
	public static final int EMPTY = 0;

	public static final String LOCK = "lock";

	 static class Producer implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (LOCK) {
					while (capacity >= FULL) {

						try {
							System.out.println(Thread.currentThread().getName() + " 发现面包装满了######");
							LOCK.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					capacity++;
					System.out.println(Thread.currentThread().getName() + " 生产了一个面包，还剩" + capacity + "个面包");
					LOCK.notifyAll();
				}

			}
		}
	}

	static class Consumer implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {

				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (LOCK) {
					while (capacity <= EMPTY) {
						try {
							System.out.println(Thread.currentThread().getName() + " 发现面包没了。。。。");
							LOCK.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					capacity--;
					System.out.println(Thread.currentThread().getName() + " 吃了一个面包，还剩" + capacity + "个面包");
					LOCK.notifyAll();
				}

			}
		}
	}

	public static void main(String[] args) {
		One one = new One();
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();

		new Thread(new Producer()).start();
		new Thread(new Producer()).start();
	}
}
