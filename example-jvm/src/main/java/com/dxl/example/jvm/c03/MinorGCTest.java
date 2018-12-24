package com.dxl.example.jvm.c03;

/**
 * @Program MinorGCTest
 * @Description
 * @Author duxl
 * @Create 2018/12/20 9:44
 */


public class MinorGCTest {
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM agrs: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8 -XX:+UseSerialGC
	 */
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];
	}

	public static void main(String[] agrs) {
		testTenuringThreshold();
	}

	/**
	 * 测试大对象直接进入老年代
	 * VM agrs: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
	 */
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB];
	}

	/**
	 * 测试长期存活的对象直接进入老年代  改变XX:+PrintTenuringDistribution=1 的值
	 * VM agrs: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 */
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation4 = new byte[4 * _1MB];
	}

}
