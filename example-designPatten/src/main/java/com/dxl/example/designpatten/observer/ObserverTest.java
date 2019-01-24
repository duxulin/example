package com.dxl.example.designpatten.observer;

import java.util.Observable;

/**
 * @Program ObserverTest
 * @Description
 * @Author duxl
 * @Create 2019/1/3 16:31
 */
public class ObserverTest {

	public static void main(String[] args) {
		Subject subject = new Subject(1);
		ManObserver manObserver = new ManObserver(subject);
		WomanObserver womanObserver = new WomanObserver(subject);
		subject.updateStatus(2);
		System.out.println("========");
		subject.updateStatus(11);
		System.out.println("========");

		ASubject observable = new ASubject();
		BObserver bObserver = new BObserver(observable);
		AObserver aObserver = new AObserver(observable);
		observable.setStatus(2);


	}
}
