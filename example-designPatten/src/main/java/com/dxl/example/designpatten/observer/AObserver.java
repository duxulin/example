package com.dxl.example.designpatten.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Program AObserver
 * @Description
 * @Author duxl
 * @Create 2019/1/3 16:52
 */
public class AObserver implements Observer {
	private Observable observable;

	public AObserver(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(this+"发现subject发生状态改变:"+arg);
	}
}
