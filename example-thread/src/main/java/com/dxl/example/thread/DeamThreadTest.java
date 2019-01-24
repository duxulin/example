package com.dxl.example.thread;

/**
 * @Program DeamThreadTest
 * @Description
 * @Author duxl
 * @Create 2019/1/7 10:48
 */
public class DeamThreadTest{

	public static int i;

	static class DeamThread implements Runnable{

		@Override
		public void run() {
			for(int j = 0;j<1000;j++,i++){
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new DeamThread());
		thread.setDaemon(true);//当系统所有非守护线程执行完毕时，jvm退出
		thread.start();
	}
}
