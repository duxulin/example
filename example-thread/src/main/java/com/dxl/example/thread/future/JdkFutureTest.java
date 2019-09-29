package com.dxl.example.thread.future;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Program JdkFutureTest
 * @Description
 * @Author duxl
 * @Create 2019/1/7 14:24
 */
public class JdkFutureTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
//		ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

		long before = System.currentTimeMillis();
		Future<?> submit = executorService.submit(new JdkRealDate("hello"));

		System.out.println(submit.get());
		long after = System.currentTimeMillis();
		System.out.println(after - before);
		executorService.shutdown();
	}
}
