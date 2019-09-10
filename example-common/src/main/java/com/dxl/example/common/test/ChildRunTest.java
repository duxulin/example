package com.dxl.example.common.test;

import javax.management.timer.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;

/**
 * 2、跑步
 * 3个小朋友参加百米跑步比赛，A小朋友每秒跑5米，B小朋友每秒跑4米，C小朋友每秒跑3米。
 * 大家做好准备之后喊一声“我准备好了”，然后在听到发令枪响后一起起步，并在开始跑步时喊一声“我开始跑步了”，
 * 当一个小朋友跑到终点时，喊一声“我到终点了”，此时记录跑了多久。其他小朋友停止跑步，并报出自己跑了多少米，例如“x小朋友跑了yy米”。
 * 请用java程序表述上面的过程
 */
public class ChildRunTest {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		new Thread(new ChildRun(5,cyclicBarrier),"A").start();
		new Thread(new ChildRun(4,cyclicBarrier),"B").start();
		new Thread(new ChildRun(3,cyclicBarrier),"C").start();
	}

}

class ChildRun implements Runnable {
	static int s = 50;
	static boolean flag = true;
	CyclicBarrier cyclicBarrier;
	int speed;


	public ChildRun(int speed,CyclicBarrier cyclicBarrier){
		this.speed = speed;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		int totalRun = 0;
		int time = 0;
		try {
			Thread.sleep(Timer.ONE_SECOND * speed);
			System.out.println(Thread.currentThread().getName() + ":我准备好了");
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName() + ":我开始跑了");
			while (flag) {
				if (totalRun >= s) {
					flag = false;
					System.out.println(Thread.currentThread().getName() + ":我到终点了用了"+time+"秒");
					return;
				}
				time++;
				totalRun += speed;
				Thread.sleep(Timer.ONE_SECOND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":我跑了"+totalRun+"米");

	}
}
