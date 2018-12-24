package com.dxl.example.jvm.c02;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @Program JavaMethodAreaOOM
 * @Description
 * @Author duxl
 * @Create 2018/12/19 17:07
 * vm args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk1.8开始无效，方法区并入堆，需设置堆内存大小
 */
public class JavaMethodAreaOOM {
	static class OOMObject {
	}

	public static void main(String[] args) {
		while (true) {
			Enhancer enhance = new Enhancer();
			enhance.setSuperclass(OOMObject.class);
			enhance.setUseCache(false);
			enhance.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invoke(o, objects));
		}
	}
}
