package com.dxl.example.jvm.c03;

/**
 * @Program FinalizeEscapeGC
 * @Description
 * @Author duxl
 * @Create 2018/12/20 10:20
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;

	public void isAlive() {
		System.out.println("yes,i am still alive");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK == null) {
			System.out.println("no, i am dead :(");
		} else {
			SAVE_HOOK.isAlive();
		}
		//same code
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK == null) {
			System.out.println("no, i am dead :(");
		} else {
			SAVE_HOOK.isAlive();
		}
	}
}
