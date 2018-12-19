package com.dxl.example.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @Program ZookeeperAPIDemo
 * @Description
 * @Author duxl
 * @Create 2018/11/20 15:38
 */
public class ZookeeperAPIDemo implements Watcher {

	private static CountDownLatch latch = new CountDownLatch(1);

	@Override
	public void process(WatchedEvent event) {
		System.out.println("Receive event:" + event);
		if (Event.KeeperState.SyncConnected == event.getState()) {
			latch.countDown();
		}
	}

	public static void main(String[] args) throws Exception {
		ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ZookeeperAPIDemo());
		System.out.println(zooKeeper.getState());
		latch.await();
		System.out.println("Zookeeper session established");
	}
}
