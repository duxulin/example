package com.dxl.example.jvm.c04;

/**
 * @Program DeadLockJConsoleTest
 * @Description
 * @Author duxl
 * @Create 2018/12/26 9:44
 */
public class DeadLockJConsoleTest {

	static class SynAddRunnable implements Runnable{
		int a,b;
		public SynAddRunnable(int a,int b){
			this.a = a;
			this.b = b;
		}

		@Override
		public void run() {
			synchronized (Integer.valueOf(a)){
				synchronized (Integer.valueOf(b)){
					System.out.println(a + b);
				}
			}
		}
	}

	public static void main(String[] args) {
		for(int i = 0;i<100;i++){
			new Thread(new SynAddRunnable(1,2)).start();
			new Thread(new SynAddRunnable(2,1)).start();
			System.out.println(i);
		}
	}
}
