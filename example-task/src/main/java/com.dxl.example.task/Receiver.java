package com.dxl.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @Program Receiver
 * @Description
 * @Author duxl
 * @Create 2018/11/14 16:56
 */
public class Receiver {
	private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch;

	@Autowired
	public Receiver(CountDownLatch latch) {
		this.latch = latch;
	}

	public void receiveMessage(String message) {
		LOG.info("Receiver <" + message + ">");
		latch.countDown();
	}
}
