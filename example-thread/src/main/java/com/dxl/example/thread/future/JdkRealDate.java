package com.dxl.example.thread.future;

import java.util.concurrent.Callable;

/**
 * @Program JdkRealDate
 * @Description
 * @Author duxl
 * @Create 2019/1/7 14:25
 */
public class JdkRealDate implements Callable<String> {
	private String data;
	public JdkRealDate(String data){
		this.data = data;
	}


	@Override
	public String call() throws Exception {
		Thread.sleep(2000);
		return data+"Future";
	}
}
