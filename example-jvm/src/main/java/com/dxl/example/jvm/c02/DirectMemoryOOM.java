package com.dxl.example.jvm.c02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Program DirectMemoryOOM
 * @Description
 * @Author duxl
 * @Create 2018/12/19 17:15
 * vm args:-Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
	private static final int _1M = 1024 * 1024;

	public static void main(String[] args) throws IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe o = (Unsafe) unsafeField.get(null);
		while (true) {
			o.allocateMemory(_1M);
		}
	}
}
