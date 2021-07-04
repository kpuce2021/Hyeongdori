
package com.kpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kpu.domain.UserVO;

@Controller
public class UserController {
	@RequestMapping(value="/registPage", method=RequestMethod.GET)
	public String registGetMethod() throws Exception{
		return "userView/registerUser";
	}
	
	@RequestMapping(value="/registProcess", method=RequestMethod.POST)
	public String registPostMethod(@ModelAttribute("user") UserVO vo) throws Exception{
		// service단에서 db에 넣어주는 기능 수행
		return "home";
	}
}
