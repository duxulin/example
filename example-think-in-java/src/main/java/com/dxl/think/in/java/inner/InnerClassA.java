package com.dxl.think.in.java.inner;

/**
 * @Program InnerClassA
 * @Description
 * @Author duxl
 * @Create 2018/12/18 9:14
 */
public class InnerClassA {
	private InnerClassA() {
	}

	public static InnerClassA getInstance() {
		return Inner.instance;
	}

	static class Inner {
		private static InnerClassA instance = new InnerClassA();

	}

	class InnerB {
		private String name;
		public Integer age;
	}

	protected class b {

	}
}

