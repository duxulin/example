package com.dxl.example.thread.future;

import java.util.concurrent.*;

/**
 * @Program JdkFutureTest
 * @Description
 * @Author duxl
 * @Create 2019/1/7 14:24
 */
public class JdkFutureTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		long before = System.currentTimeMillis();
		Future<?> submit = executorService.submit(new JdkRealDate("hello"));

		System.out.println(submit.get());
		long after = System.currentTimeMillis();
		System.out.println(after - before);
		executorService.shutdown();
	}
}
