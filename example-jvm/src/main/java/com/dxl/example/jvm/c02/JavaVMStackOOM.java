package com.dxl.example.jvm.c02;

/**
 * @Program JavaVMStackOOM
 * @Description
 * @Author duxl
 * @Create 2018/12/19 16:23
 * VM Args:-Xss2M
 * warning：执行可能会造成系统假死，请先保存所有打开文件进度
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
