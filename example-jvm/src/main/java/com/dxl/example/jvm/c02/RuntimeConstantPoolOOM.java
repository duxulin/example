package com.dxl.example.jvm.c02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program RuntimeConstantPoolOOM
 * @Description
 * @Author duxl
 * @Create 2018/12/19 16:40
 * VM Args: -XX:PermSize10M -XX:MaxPermSize10M
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
//		int i = 0;
//		List<String> list = new ArrayList<>();
//		while (true){
//			list.add(String.valueOf(i++).intern());
//		}

		String s1 = new StringBuilder("haha").append("hoho").toString();
		System.out.println(s1.intern() == s1);

		String s2 = new StringBuilder("aa").append("bb").toString();
		System.out.println(s2.intern() == s2);
	}

}
