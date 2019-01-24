package com.dxl.example.designpatten.observer;

import java.util.Map;
import java.util.Observable;

/**
 * @Program ManObserver
 * @Description
 * @Author duxl
 * @Create 2019/1/3 16:29
 */

/**
 * 具体的观察者实现 当被观察者的状态发生变化时，会做出相应的动作
 */
public class ManObserver extends BaseObserver {
	public ManObserver(Subject subject){
		this.subject = subject;
		subject.attention(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("manObserver attention subject change:"+subject.getStatus());
	}
}
