package com.dxl.example.jvm.c04;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program OOMObject
 * @Description
 * @Author duxl
 * @Create 2018/12/26 8:51
 * vm args: -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class OOMObject {

	public byte[] placeholder = new byte[64 * 1024];

	public static void main(String[] args) throws InterruptedException {
		fillHeap();
		System.gc();

	}
	public static void fillHeap()throws InterruptedException {

		List<OOMObject> list = new ArrayList<>();
		for(int i = 0;i<1000;i++){
			Thread.sleep(50);
			list.add(new OOMObject());
		}
	}
}
