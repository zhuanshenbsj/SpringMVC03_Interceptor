package com.wcxu.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.form")
	public String hello() {
		System.out.println("--HelloController.hello--");
		return "Hello";// 返回视图组件的名字

	}

}
