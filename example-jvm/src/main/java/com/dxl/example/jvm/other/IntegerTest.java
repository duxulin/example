package com.dxl.example.jvm.other;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @Program IntegerTest
 * @Description
 * @Author duxl
 * @Create 2019/1/16 9:53
 */
public class IntegerTest {

//	static {
//		try {
//			Class<?> aClass = Class.forName("java.lang.Integer$IntegerCache");
//			Field cache = aClass.getDeclaredField("cache");
//			cache.setAccessible(true);
//			Integer[] cache1 = (Integer[])cache.get("cache");
//			for(int i = 0;i<cache1.length;i++){
//				cache1[i] = new Integer(new Random().nextInt(cache1.length));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
//		Object o = true?new Integer(1):new Double(2);
//		System.out.println(o);

//
//		Integer i = new Integer(1);
//		if (i.equals(1))
//			i = null;
//		Double d = new Double(2.0);
//		Object o = true ? i : d; // NullPointerException!
//		System.out.println(o);

//		for(int i = 0;i<10;i++){
//			System.out.println((Integer)i);
//			Integer.valueOf(1);
//		}

		// 编译无法通过
		// 详见 https://github.com/oldratlee/translations/blob/master/10-things-you-didnt-know-about-java/README.md
//		Type<? super C> c = new C();
//		Type<? super D<Byte>> d = new D<Byte>();
	}
}

interface Type<T> {
}

class C implements Type<Type<? super C>> {
}

class D<P> implements Type<Type<? super D<P>>> {
}
