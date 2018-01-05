package com.wcxu.interceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CheckLoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// 执行登录检查：检测用户session中是否含有登录添加的信息
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		if (user == null) {// 如果没有信息，组织controller调用
			response.sendRedirect("login.jsp");// 定位到登录页面
			return false;
		} else {
			return true;// 合法，通过检测，继续执行
		}
	}

}
