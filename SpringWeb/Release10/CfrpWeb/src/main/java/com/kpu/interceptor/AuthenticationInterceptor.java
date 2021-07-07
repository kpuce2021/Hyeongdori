package com.kpu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kpu.domain.ScriptUtils;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
		
		if(obj == null) {
			ScriptUtils.alertAndMovePage(response, "로그인 후 이용 가능합니다.", "http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/main/home");
			//response.sendRedirect("/main-1.0.0-BUILD-SNAPSHOT/main/home");
			return false;
		}
		
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		super.postHandle(request, response, handler, modelAndView);
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		
	}
}
