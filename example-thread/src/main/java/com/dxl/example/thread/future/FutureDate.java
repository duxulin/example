package com.dxl.example.thread.future;

/**
 * @Program FutureDate
 * @Description
 * @Author duxl
 * @Create 2019/1/7 13:53
 */
public class FutureDate implements Date {
	protected RealDate realDate = null;
	protected boolean isReady = false;

	public synchronized void setRealDate(RealDate realDate){
		if(isReady){
			return;
		}
		this.realDate = realDate;
		isReady = true;
		notifyAll();
	}

	@Override
	public synchronized String getResult() {
		while (!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realDate.getResult();
	}
}
