package com.dxl.example.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Program NettyApplicationTests
 * @Description
 * @Author duxl
 * @Create 2018/11/15 11:11
 */
@SpringBootApplication
public class NettyApplicationTests {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(NettyApplicationTests.class);
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
}
