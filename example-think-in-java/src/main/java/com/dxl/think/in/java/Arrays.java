package com.dxl.think.in.java;


/**
 * @Program Arrays
 * @Description
 * @Author duxl
 * @Create 2018/12/17 14:54
 */
public class Arrays {
	public static void main(String[] args) {
		int[] a1 = {1, 2, 3, 4, 5};
		int[] a2;
		a2 = a1;
		for (int i = 0; i < a2.length; i++)
			a2[i]++;
		for (int i = 0; i < a1.length; i++)
			prt("a1[" + i + "] = " + a1[i]);
	}

	static void prt(String s) {
		System.out.println(s);
		Integer[] b = new Integer[]{
				new Integer(1),
				new Integer(2),
				new Integer(3),
		};
		Integer[] a = {
				new Integer(1),
				2,
				new Integer(3),
		};
	}
}
