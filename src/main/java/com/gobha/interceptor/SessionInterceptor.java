package com.gobha.interceptor;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	private final static String SESSION_KEY = "session_user";

	@Override
	public boolean preHandle( HttpServletRequest request , HttpServletResponse response , Object handler )
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute(SESSION_KEY)==null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('你没有登陆！');"
					+ "window.top.location.href='"+request.getContextPath()+"/sys/login';"
					+ "</script>");
			out.flush();
			out.close();
			return false;
		}else{
			return true;
		}
	}
}

