package com.dx.example.dubbo.edas.producer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.dxl.example.common.IHelloService;
import org.springframework.stereotype.Component;

/**
 * @Program HelloServiceImpl
 * @Description
 * @Author duxl
 * @Create 2019/1/25 10:01
 */
@Component
@Service
public class HelloServiceImpl implements IHelloService {
	@Override
	public String sayHello(String str) {
		return String.format("Hello %s Welcome to Java",str);
	}
}
