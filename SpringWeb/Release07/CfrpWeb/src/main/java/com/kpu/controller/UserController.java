
package com.kpu.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kpu.domain.UserVO;
import com.kpu.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@RequestMapping(value="/registPage", method=RequestMethod.GET)
	public String registGetMethod() throws Exception{
		return "userView/registerUser";
	}
	
	@RequestMapping(value="/registProcess", method=RequestMethod.POST)
	public String registPostMethod(@ModelAttribute("user") UserVO vo) throws Exception{
		uService.addUser(vo);
		return "home";
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginPostMethod(HttpSession session, UserVO vo, HttpServletResponse response) throws Exception{
		if(session.getAttribute("login") != null)
			session.removeAttribute("login");
		
		UserVO loginUser = uService.loginUser(vo);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(loginUser == null) {
			out.println("<script>alert('로그인 정보를 확인해주세요.');</script>");
			return "redirect:/home";
		}
		else { // 로그인 성공
			session.setAttribute("login", loginUser);
			out.println("<script>alert('로그인 완료');</script>");
		}
		//return "redirect:/home";
		return "home";
	}
	
	@RequestMapping(value="/logoutProcess", method=RequestMethod.GET)
	public String logoutMethod(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
