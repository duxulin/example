package com.dxl.example.thread.future;

/**
 * @Program Client
 * @Description
 * @Author duxl
 * @Create 2019/1/7 14:13
 */
public class Client {
	public Date quest(String date) {
		FutureDate futureDate = new FutureDate();

		new Thread(() -> {

			RealDate realDate = new RealDate(date);
			futureDate.setRealDate(realDate);
		}).start();
		return futureDate;

	}


}
