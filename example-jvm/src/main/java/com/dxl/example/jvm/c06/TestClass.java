package com.dxl.example.jvm.c06;

/**
 * @Program TestClass
 * @Description
 * @Author duxl
 * @Create 2018/12/27 11:28
 */
public class TestClass {
	private int m;
	public int inc(){
		int x;
		try{
			x = 1;
			return x;
		}catch (Exception e){
			x = 2;
			return x;
		}finally {
			x = 3;
		}
	}
	protected  static void fa(){

	}
	static String returns(String s){
		return s;
	}

	public static void main(String[] args) {
		double d1 = 0.7d-0.6d;
		double d2 = 0.6-0.5d;
		System.out.println(d1 == d2);
	}
}
