package com.dxl.example.thread.future;

/**
 * @Program RealDate
 * @Description
 * @Author duxl
 * @Create 2019/1/7 13:57
 */
public class RealDate implements Date {
	private String result;

	public RealDate(String data) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			sb.append(data);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = sb.toString();
	}


	@Override
	public String getResult() {

		return result;
	}
}
