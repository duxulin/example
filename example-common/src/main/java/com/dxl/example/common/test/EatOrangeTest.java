package com.dxl.example.common.test;

import javax.management.timer.Timer;
import java.util.concurrent.CountDownLatch;

/**
 * 1、吃桔子
 * 共计9个桔子，有3个小朋友，小朋友A每次拿2个桔子，小朋友B每次拿3个桔子，小朋友C每次拿1个桔子，小朋友10s吃1个桔子，吃完后继续去拿。
 * 小朋友每次拿桔子之前和拿了桔子之后，都会对桔子数量进行报数。
 * 如果剩余的桔子不够小朋友每次拿的数量，小朋友停止拿桔子，喊一声“不拿了”并退出游戏。
 * 请用java多线程程序表述上面的过程。
 */
public class EatOrangeTest {


	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		new Thread(new EatChild(2,countDownLatch),"A").start();
		new Thread(new EatChild(3,countDownLatch),"B").start();
		new Thread(new EatChild(1,countDownLatch),"C").start();
		countDownLatch.await();
		System.out.println("game over");

	}
}

class EatChild implements Runnable {

	CountDownLatch countDownLatch;
	static int totalOrangeNum = 9;
	static int perRest = 5;
	int perEatNum;

	public EatChild(int perEatNum,CountDownLatch countDownLatch) {
		this.perEatNum = perEatNum;
		this.countDownLatch = countDownLatch;
	}


	@Override
	public void run() {
		while (true) {
			synchronized (EatChild.class) {
				System.out.println(Thread.currentThread().getName() + ":拿前有" + totalOrangeNum + "个");
				if (totalOrangeNum - perEatNum < 0) {
					System.out.println(Thread.currentThread().getName() + ":不拿了");
					countDownLatch.countDown();
					break;
				}else{
					totalOrangeNum -=perEatNum;
				}
				System.out.println(Thread.currentThread().getName() + ":拿后有" + totalOrangeNum + "个");

			}
			try {
				Thread.sleep(Timer.ONE_SECOND * perRest * perEatNum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
