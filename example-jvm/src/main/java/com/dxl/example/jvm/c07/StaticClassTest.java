package com.dxl.example.jvm.c07;

/**
 * @Program StaticClassTest
 * @Description
 * @Author duxl
 * @Create 2018/12/29 9:13
 */
public class StaticClassTest {

	static class DeadLoopClass{
		//静态块中如果不加if判断，则无法通过编译
		static {
			if(true){
				System.out.println(Thread.currentThread()+"init DeadLoopClass");
				while (true){}
			}
		}
	}

	public static void main(String[] args) {
		Runnable runnable = () -> {
			System.out.println(Thread.currentThread() + "start");
			DeadLoopClass deadLoopClass = new DeadLoopClass();
			System.out.println(Thread.currentThread() + "run over");
		};
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread2.start();
	}
}
