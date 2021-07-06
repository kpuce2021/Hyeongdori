
package com.kpu.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String registPostMethod(HttpSession session, UserVO vo) throws Exception{
		if(session.getAttribute("login") != null)
			session.removeAttribute("login");
		
		int result = uService.userIdCheck(vo);
		
		
		try {
			if(result == 1) {
				return "userView/registerUser";
			}
			else if(result == 0) {
				uService.addUser(vo);
				session.setAttribute("login", vo);
			}
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
		
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
			return "redirect:/main/home";
		}
		else { // 로그인 성공
			session.setAttribute("login", loginUser);
			out.println("<script>alert('로그인 완료');</script>");
		}
		
		return "home";
	}
	
	@RequestMapping(value="/logoutProcess", method=RequestMethod.GET)
	public String logoutMethod(HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/idChk", method=RequestMethod.POST)
	public int idChkMethod(UserVO vo) throws Exception{
		int result = uService.userIdCheck(vo);
		return result;
	}
}
