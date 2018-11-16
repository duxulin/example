package com.dxl.example.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Program Example
 * @Description
 * @Author duxl
 * @Create 2018/11/15 15:34
 */
public class Example {

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new ExponentialBackoffRetry(1000, 3));
        try {
            curatorFramework.start();
            String s = curatorFramework.create().forPath("/curatorExample");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
