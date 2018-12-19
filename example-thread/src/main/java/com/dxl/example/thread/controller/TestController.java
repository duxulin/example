package com.dxl.example.thread.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Program TestController
 * @Description
 * @Author duxl
 * @Create 2018/12/18 13:26
 */
@Controller()
public class TestController {
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
}
