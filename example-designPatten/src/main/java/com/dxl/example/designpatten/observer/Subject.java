package com.dxl.example.designpatten.observer;

import org.springframework.objenesis.ObjenesisSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @Program Subject
 * @Description
 * @Author duxl
 * @Create 2019/1/3 16:25
 */

/**
 * 被观察对象，当状态改变时，观察者会做相应的动作
 */
public class Subject {
	private int status;

	private List<Observer> observerList = new ArrayList<>();

	public Subject(int status){
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void updateStatus(int status) {
		this.status = status;
		note();
	}

	public void attention(Observer observer){
		observerList.add(observer);
	}


	public void note(){
		for(Observer observer:observerList){
			observer.update(null,null);
		}
	}
}
