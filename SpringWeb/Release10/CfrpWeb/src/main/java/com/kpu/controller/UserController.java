
package com.kpu.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kpu.domain.ResultVO;
import com.kpu.domain.ScriptUtils;
import com.kpu.domain.UserVO;
import com.kpu.service.ResultService;
import com.kpu.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@Autowired
	private ResultService rService;
	
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
	public void loginPostMethod(HttpSession session, UserVO vo, HttpServletResponse response, Model model) throws Exception{
		if(session.getAttribute("login") != null)
			session.removeAttribute("login");
		
		UserVO loginUser = uService.loginUser(vo);
		
		if(loginUser == null) {
			ScriptUtils.alertAndMovePage(response, "아이디 및 비밀번호를 확인하세요", "http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/main/home");
		}
		else { // 로그인 성공
			session.setAttribute("login", loginUser);
			ScriptUtils.alertAndMovePage(response, "로그인 성공", "http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/main/home");
		}

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
	
	@RequestMapping(value="/myInfo", method=RequestMethod.GET)
	public String myInfoMethod(HttpSession session, UserVO uVO, ResultVO rVO, Model model) throws Exception{
		uVO = (UserVO) session.getAttribute("login");
		uVO = uService.readUser(uVO.getId());
		
		List<ResultVO> resultList = rService.readAllByUserId(uVO.getId());
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("user", uVO);
		return "userView/MyInfoPage";
	}
	
	@RequestMapping(value="/modifyUser", method=RequestMethod.GET)
	public String modifyUserMethod() throws Exception{
		return "userView/modifyUserPage";
	}
}
