package com.dxl.example.jvm.c07;

/**
 * @Program NothingInit
 * @Description
 * @Author duxl
 * @Create 2018/12/28 10:51
 */
public class NothingInit {
	public static void main(String[] args) {
		//System.out.println(SubClass.value);
		SuperClass[] superClasses = new SuperClass[10];
		System.out.println(superClasses.getClass());
	}
}
