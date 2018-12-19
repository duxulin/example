package com.dxl.example.jvm.c02;

/**
 * @Program JavaVMStackOOM
 * @Description
 * @Author duxl
 * @Create 2018/12/19 16:23
 * VM Args:-Xss2M
 */
public class JavaVMStackOOM {
	private void dontStop() {
		while (true) {
		}
	}

	public void stackLeakByThread() {
		while (true) {
			new Thread(() ->
					dontStop()
			).start();
		}
	}

	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
