package com.dxl.example.thread.producer$consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Program Three
 * @Description
 * @Author duxl
 * @Create 2019/1/7 13:06
 */
public class Three {
	private static int capacity;
	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	class Producer implements Runnable{
		@Override
		public void run() {
			for(int i = 0;i<10;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				try {
					queue.put(1);
					capacity++;
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
					capacity--;
					System.out.println(Thread.currentThread().getName() + " 吃了一个面包，还剩" + capacity + "个面包");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Three three = new Three();
		new Thread(three.new Consumer()).start();
		new Thread(three.new Producer()).start();
		new Thread(three.new Consumer()).start();
		new Thread(three.new Consumer()).start();

		new Thread(three.new Producer()).start();
		new Thread(three.new Producer()).start();
	}

}
