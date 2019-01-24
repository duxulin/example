package com.dxl.example.designpatten.observer;

import java.util.Observable;

/**
 * @Program ASubject
 * @Description
 * @Author duxl
 * @Create 2019/1/3 16:45
 */
public class ASubject extends Observable {


	public int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
		setChanged();
		notifyObservers(status);
	}


}
