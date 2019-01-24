package com.dxl.example.jvm.other;

/**
 * @Program Parent
 * @Description
 * @Author duxl
 * @Create 2019/1/16 9:34
 */
public abstract class Parent<T> {
	abstract T x();
}
class Child extends Parent<String>{
	int[][] arr1 = {{}};
	int [] arr2 [] = {{}};
	int arr3 []  [] = {{}};

	@Override
	String x() {
		return "abc";
	}
}
