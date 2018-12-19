package com.dxl.think.in.java;

/**
 * @Program StaticInitialization
 * @Description
 * @Author duxl
 * @Create 2018/12/17 14:23
 */
class Bowl {
	Bowl(int marker) {
		System.out.println("Bowl(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Table {
	static Bowl b1 = new Bowl(1);

	Table() {
		System.out.println("Table()");
		b2.f(1);
	}

	void f2(int marker) {
		System.out.println("f2(" + marker + ")");
	}

	static Bowl b2 = new Bowl(2);
}

class Cupboard {
	Bowl b3 = new Bowl(3);
	static Bowl b4 = new Bowl(4);

	static {
		System.out.println("static");
	}

	Cupboard() {
		System.out.println("Cupboard()");
		b4.f(2);
	}

	void f3(int marker) {
		System.out.println("f3(" + marker + ")");
	}

	static Bowl b5 = new Bowl(5);
}

public class StaticInitialization {
	public static void main(String[] args) {
//		System.out.println(
//				"Creating new Cupboard() in main");
//		new Cupboard();
//		System.out.println(
//				"Creating new Cupboard() in main");
//		new Cupboard();
//		t2.f2(1);
//		t3.f3(1);
		try {
			Class.forName("com.dxl.think.in.java.Cupboard");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	static Table t2 = new Table();
//	static Cupboard t3 = new Cupboard();
} ///:
