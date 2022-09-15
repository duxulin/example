package com.dxl.example.thread.producer$consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Program Three
 * @Description
 * @Author duxl
 * @Create 2019/1/7 13:06
 */
public class Three {
	private volatile static AtomicInteger capacity= new AtomicInteger();
	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	class Producer implements Runnable{
		@Override
		public void run() {
			for(int i = 0;i<10;i++){
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				try {
					queue.put(1);
					capacity.getAndIncrement();
					System.out.println(Thread.currentThread().getName() + " 生产了一个面包，还剩" + capacity + "个面包");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class Consumer implements Runnable{
		@Override
		public void run() {
			for(int i = 0;i<10;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				try {
					queue.take();
					capacity.getAndDecrement();
					System.out.println(Thread.currentThread().getName() + " 吃了一个面包，还剩" + capacity + "个面包");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread current = Thread.currentThread();
		Three three = new Three();
		Thread c1 = new Thread(three.new Consumer());
		c1.start();
		Thread g1 = new Thread(three.new Producer());
		g1.start();
		Thread c2 = new Thread(three.new Consumer());
		c2.start();
		Thread c3 = new Thread(three.new Consumer());
		c3.start();

		Thread g2 = new Thread(three.new Producer());
		g2.start();
		Thread g3 = new Thread(three.new Producer());
		g3.start();
		c1.join();
		g1.join();
		c2.join();
		c3.join();
		g2.join();
		g3.join();

	}

}
