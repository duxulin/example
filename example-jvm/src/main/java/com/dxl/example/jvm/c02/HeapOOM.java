package com.dxl.example.jvm.c02;

import java.util.ArrayList;

/**
 * @Program HeapOOM
 * @Description
 * @Author duxl
 * @Create 2018/12/19 11:27
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
	static class OOMObject {

	}

	public static void main(String[] args) {
		ArrayList<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
