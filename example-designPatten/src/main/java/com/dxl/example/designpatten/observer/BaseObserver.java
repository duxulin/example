package com.dxl.example.designpatten.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Program BaseObserver
 * @Description
 * @Author duxl
 * @Create 2019/1/3 16:24
 */
public abstract class BaseObserver implements Observer {
	protected Subject subject;
}
