package com.dxl.think.in.java.c06;

/**
 * @Program Cartoon
 * @Description
 * @Author duxl
 * @Create 2018/12/18 10:42
 */
//: Cartoon.java
// Constructor calls during inheritance
class Art {
	static {
		System.out.println("static Art");
	}

	Art() {
		System.out.println("Art constructor");
	}
}

class Drawing extends Art {
	static {
		System.out.println("static Drawing");
	}

	Drawing() {
		System.out.println("Drawing constructor");
	}
}

public class Cartoon extends Drawing {
	static {
		System.out.println("static Cartoon");
	}

	Cartoon() {
		System.out.println("Cartoon constructor");

	}

	public static void main(String[] args) {
		Cartoon x = new Cartoon();
	}
} ///:~
