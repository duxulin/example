package com.dxl.example.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Program IndexController
 * @Description
 * @Author duxl
 * @Create 2019/1/2 11:26
 */
@Controller
@RequestMapping
public class IndexController {


	@RequestMapping(value = "/helloadmin", method=RequestMethod.GET)
	public String helloAdmin(){
		return "helloAdmin";
	}

	@RequestMapping(value = "/hellouser", method=RequestMethod.GET)
	public String helloUser(){
		return "helloUser";
	}

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(@RequestParam(value = "error",required = false) String error , Model model){
		if(error != null){
			model.addAttribute("error","登录信息校验失败");
		}
		return "myLogin";
	}

	@RequestMapping("/403")
	public String forbidden(){
		return "403";
	}

}
