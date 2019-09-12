package com.dx.example.dubbo.edas.consumer.spi;

import com.alibaba.dubbo.common.extension.SPI;

@SPI("dog")
public interface Animal {

	void eat();
}
