package com.dxl.example.jvm.c03;

/**
 * @Program ReferenceCountingGC
 * @Description
 * @Author duxl
 * @Create 2018/12/20 9:15
 * vm args:-XX:+PrintGCDetails
 */
public class ReferenceCountingGC {
	public Object reference = null;
	private static final int _1M = 1024 * 1024;
	private byte[] bigSize = new byte[_1M];

	public static void main(String[] args) {
		ReferenceCountingGC obj1 = new ReferenceCountingGC();
		ReferenceCountingGC obj2 = new ReferenceCountingGC();
		obj1.reference = obj2;
		obj2.reference = obj1;

		obj1 = null;
		obj2 = null;

		System.gc();

	}
}
