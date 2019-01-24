package com.dxl.example.jvm.other;

import java.lang.ref.Reference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Program Ref
 * @Description
 * @Author duxl
 * @Create 2019/1/23 13:48
 */
public class Ref {


	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		List<String> list = new ArrayList<>();
		Method m_Add = list.getClass().getDeclaredMethod("add", Object.class);
		m_Add.setAccessible(true);
		m_Add.invoke(list,"abc");
		m_Add.invoke(list,new Integer(111));
		m_Add.invoke(list,new HashMap<>());

//		for ( Object o: list){
//			System.out.println(o);
//		}
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}

	}

	public static void maiin(String[] args) {
		List<Integer> ls = new ArrayList<>();
		ls.add(23);
//		ls.add("text");
		try {
			Method method = ls.getClass().getDeclaredMethod("add",Object.class);


			method.invoke(ls,"test");
			method.invoke(ls,42.9f);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for ( Object o: ls){
			System.out.println(o);
		}

	}

}
