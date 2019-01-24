package com.dxl.example.jvm.other;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Program TimeTest
 * @Description
 * @Author duxl
 * @Create 2019/1/16 13:20
 */
public class TimeTest {

	public static void main(String[] args) {

	}

	public void each(List<String> lists){
		for(String s:lists){
			System.out.println(s);
		}
	}

	public void each1(List<Integer> lists){
		Iterator<Integer> iterator = lists.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
