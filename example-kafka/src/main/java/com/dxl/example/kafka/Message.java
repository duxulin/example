package com.dxl.example.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @Program Message
 * @Description
 * @Author duxl
 * @Create 2018/11/29 13:58
 */
@Data
public class Message {

	private Long id;
	private String msg;
	private Date sendTime;  //时间戳
}
