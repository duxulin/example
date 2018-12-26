package com.dxl.example.jvm.c04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Program ThreadJConsoleTest
 * @Description
 * @Author duxl
 * @Create 2018/12/26 9:25
 */
public class ThreadJConsoleTest {



	public static void createBysyThread() {
		new Thread(() -> {
			while (true) {
			}
		}, "testBusyThread").start();
	}

	public static void createLockThread(Object lock) {
		new Thread(() -> {
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"lockThread").start();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br.readLine();
//		createBysyThread();
		br.readLine();
		Object o = new Object();
		createLockThread(o);
	}
}
