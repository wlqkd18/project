package com.kgitbank.ssg.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kgitbank.ssg.member.service.MemberService;

public class LoginCheck extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		MemberService ms = new MemberService();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String msg = "로그인 후 이용이 가능합니다.";
			String url = "/ssg/";
			out.print(ms.getMessage(msg, url));
			return false;
		}
		return true;
	}
}
