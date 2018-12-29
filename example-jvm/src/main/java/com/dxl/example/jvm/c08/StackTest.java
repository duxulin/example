package com.dxl.example.jvm.c08;

/**
 * @Program StackTest
 * @Description
 * @Author duxl
 * @Create 2018/12/29 14:07
 *
 * vm args: -XX:+PrintGCDetails
 */
public class StackTest {

	public static void main(String[] args) {
		test3();
	}
	//gc无法回收
	public static void test1(){
		byte[] bytes = new byte[1024 * 1024 * 50];
		System.gc();
	}

	//gc无法回收 局部变量表中作用域已失效，但仍有GC root对它的关联
	public static void test2(){
		{
			byte[] bytes = new byte[1024 * 1024 * 50];
		}
		System.gc();
	}
	//gc会回收，因为变量i复用了bytes的solt槽地址；
	public static void test3(){
		{
			byte[] bytes = new byte[1024 * 1024 * 50];
		}
		int i = 0;
		System.gc();
	}
}
