package com.dx.example.dubbo.edas.consumer.spi;

public class Dog implements Animal {
	@Override
	public void eat() {
		System.out.println("dog eat");
	}
}
