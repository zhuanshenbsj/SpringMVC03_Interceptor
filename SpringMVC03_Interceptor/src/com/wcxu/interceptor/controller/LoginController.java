package com.wcxu.interceptor.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	// 1. 使HttpServletRequest
	@RequestMapping("/login.form")
	public String checkLogin(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println(name + "/" + pwd);
		// service+dao对name和pwd进行检查,省略
		request.setAttribute("name", name);
		request.setAttribute("password", pwd);
		return "ok";// 返回ok.jsp
	}

	// 2. 利用@RequestParam
	@RequestMapping("/login1.form")
	public String checkLogin1(@RequestParam("username") String name, @RequestParam("password") String pwd,
			Model model) {
		model.addAttribute("name", name);
		// 将name放入Model中
		// 默认为Request，等价于request.setAttribute("name", name);
		System.out.println(name + "/" + pwd);
		// service+dao对name和pwd进行检查,省略
		return "ok";// 返回ok.jsp
	}

	// 2.1 如果参数名跟form表单对应，则可以省略@RequestParam
	@RequestMapping("/login2.form")
	public String checkLogin2(String username, String password) {
		System.out.println(username + "/" + password);
		// service+dao对name和pwd进行检查,省略
		return "ok";// 返回ok.jsp
	}

	// 3. 利用实体对象接受
	@RequestMapping("/login3.form")
	public ModelAndView checkLogin3(User usr) {
		System.out.println(usr.getUsername() + "/" + usr.getPassword());
		// service+dao对name和pwd进行检查,省略
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ok");
		mav.getModel().put("name", usr.getUsername());
		return mav;// 返回ok.jsp
	}
}
