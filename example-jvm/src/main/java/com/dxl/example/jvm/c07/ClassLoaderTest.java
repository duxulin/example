package com.dxl.example.jvm.c07;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Program ClassLoaderTest
 * @Description
 * @Author duxl
 * @Create 2018/12/29 9:32
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = new ClassLoader(){
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String className = name.substring(name.lastIndexOf(".")+1)+ ".class";
					InputStream is = getClass().getResourceAsStream(className);
					if(is ==null){
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name,b,0,b.length);
				}catch (IOException e){
					throw new ClassNotFoundException(name);
				}
			}
		};
		//不同类加载器加载的同一个class文件 是不同的
		Object o = classLoader.loadClass("com.dxl.example.jvm.c07.NothingInit").newInstance();
		System.out.println(o.getClass());
		System.out.println(o instanceof com.dxl.example.jvm.c07.NothingInit);
		while (true){

		}
	}
}
