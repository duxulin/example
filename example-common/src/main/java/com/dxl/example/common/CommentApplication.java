package com.dxl.example.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Program CommentApplication
 * @Description
 * @Author duxl
 * @Create 2018/11/14 16:00
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class);
    }
}
