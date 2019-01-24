package com.dxl.example;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Program SyncConfig
 * @Description
 * @Author duxl
 * @Create 2019/1/11 10:52
 */
public class SyncConfig implements Watcher {

	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static ZooKeeper zk = null;
	private static Stat stat = new Stat();

	public static void main(String[] args) throws Exception {
		String path = "/syncConfig";
		zk = new ZooKeeper("localhost",5000,new SyncConfig());
		countDownLatch.await();
		System.out.println(new String(zk.getData(path,true,stat)));

		Thread.sleep(Integer.MAX_VALUE);
	}

	@Override
	public void process(WatchedEvent event) {
		if (Event.KeeperState.SyncConnected == event.getState()) {
			if (Event.EventType.None == event.getType() && null == event.getPath()) {
				countDownLatch.countDown();
			} else if (event.getType() == Event.EventType.NodeDataChanged) {
				try {
					System.out.println("配置已修改，新值为："+ new String(zk.getData(event.getPath(),true,stat)));
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
