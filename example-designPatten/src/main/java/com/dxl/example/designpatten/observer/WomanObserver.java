package com.dxl.example.designpatten.observer;

import java.util.Observable;

/**
 * @Program ManObserver
 * @Description
 * @Author duxl
 * @Create 2019/1/3 16:29
 */
public class WomanObserver extends BaseObserver {
	public WomanObserver(Subject subject){
		this.subject = subject;
		subject.attention(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("womanObserver attention subject change:"+subject.getStatus());
	}
}
