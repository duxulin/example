package com.dxl.example.netty.protocol;

import lombok.Getter;
import lombok.Setter;

/**
 * @Program Response
 * @Description
 * @Author duxl
 * @Create 2018/11/15 11:34
 */
@Setter
@Getter
public class Response {

	private long requestId;
	private Object response;
	private Throwable throwable;
}
