package com.dxl.example.jvm.c07;

/**
 * @Program InitTestClass
 * @Description
 * @Author duxl
 * @Create 2018/12/28 8:39
 */
public class InitTestClass {

	public static void main(String[] args) {
		Object o = Other.s2;
	}
}

class Other{
	public static int a = 2;

	public static Object o = new Object();

	public static final Object o1 = new Object();
	public static final int  i1 = 3;
	public static final String s1 = "abc";
	public static final String s2 = "bs";


	static{
		System.out.println("Other被初始化咯");
	}
}
