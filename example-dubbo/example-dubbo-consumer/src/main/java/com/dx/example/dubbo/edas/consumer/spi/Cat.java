package com.dx.example.dubbo.edas.consumer.spi;

public class Cat implements Animal {
	@Override
	public void eat() {
		System.out.println("cat eat");
	}
}
