package com.dxl.example.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program ZookeeperStart
 * @Description
 * @Author duxl
 * @Create 2018/11/13 17:08
 */
public class ZookeeperStart {
	private static final Logger log = LoggerFactory.getLogger(ZookeeperStart.class);
	private static ArrayList<ACL> ids = ZooDefs.Ids.OPEN_ACL_UNSAFE;
	private static CreateMode createMode = CreateMode.PERSISTENT;

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		String hostPort = "localhost:2181";
		String zpath = "/";
		List<String> zooChildren = new ArrayList<String>();
		ZooKeeper zk = new ZooKeeper(hostPort, 2000, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				System.out.println(Thread.currentThread().getName() + ": 已经触发了" + event.getType() + "事件！");
			}
		});
		zk.create("/abc", "/abc".getBytes(), ids, createMode);
		//zk.create("/ab/abcaaaa","abcaaa".getBytes(),ids,createMode);
		//System.out.println("node /abc/abc1's Data:" + new String(zk.getData("/abc/abc1", true, null)));
		//zk.setData("/abc/abc1","aaabbbccc".getBytes(),10);

		if (zk != null) {
			try {
				log.debug("debug-test");
				zooChildren = zk.getChildren(zpath, true);

				System.out.println("Znodes of '/': ");

				for (String child : zooChildren) {
					//print the children
					System.out.println(child);
				}

				Stat exists = zk.exists("/abc", true);
				System.out.println("/abc's stat:" + exists);
				System.out.println("node /abc's version is:" + exists.getVersion());

				//System.out.println("node /abc/abc1's Data:" + new String(zk.getData("/abc/abc1", true, null)));
				zk.delete("/abc", exists.getVersion());
			} catch (KeeperException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				zk.close();
			}
		}


	}
}
