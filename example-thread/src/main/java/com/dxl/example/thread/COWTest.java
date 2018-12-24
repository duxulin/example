package com.dxl.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Program COWTest
 * @Description
 * @Author duxl
 * @Create 2018/12/21 8:59
 */
public class COWTest {


	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		List<String> cowList = new CopyOnWriteArrayList();
		for (int i = 0; i < 20; i++) {
			list.add(String.valueOf(i));
			cowList.add(String.valueOf(i));
		}
	}
}
