package com.dxl.example.thread.future;

/**
 * @Program FutureTest
 * @Description
 * @Author duxl
 * @Create 2019/1/7 14:16
 */
public class FutureTest {

	public static void main(String[] args) throws InterruptedException {
		Client client = new Client();
		long before = System.currentTimeMillis();
		Date data = client.quest("test");
		Thread.sleep(2000);
		System.out.println(data.getResult());
		long after = System.currentTimeMillis();
		System.out.println(after - before);
	}
}
