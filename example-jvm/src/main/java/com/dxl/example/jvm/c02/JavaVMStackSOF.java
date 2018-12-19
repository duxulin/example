package com.dxl.example.jvm.c02;

/**
 * @Program JavaVMStackSOF
 * @Description
 * @Author duxl
 * @Create 2018/12/19 16:00
 * VM Args:-Xss128k
 */
public class JavaVMStackSOF {

	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
		try {

			javaVMStackSOF.stackLeak();
		} catch (Throwable e) {
			System.out.println(javaVMStackSOF.stackLength);
			throw e;
		}
	}
}
