package com.dx.example.dubbo.edas.consumer.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

public class SpiTest {


	@Test
	public void javaSpiTest(){
		ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
		serviceLoader.forEach(Animal::eat);
	}


	@Test
	public void dubboSpiTest(){
		ExtensionLoader<Animal> extensionLoader = ExtensionLoader.getExtensionLoader(Animal.class);
		Animal dog = extensionLoader.getExtension("dog");
		Animal cat = extensionLoader.getExtension("cat");
		Animal aTrue = extensionLoader.getExtension("true");
		dog.eat();
		cat.eat();
		aTrue.eat();

	}

}
