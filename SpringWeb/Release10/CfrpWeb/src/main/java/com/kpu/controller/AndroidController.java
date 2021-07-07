package com.kpu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kpu.domain.UserVO;
import com.kpu.service.UserService;

// 안드로이드 스프링 Mysql 연동 : https://m.blog.naver.com/rhrkdfus/221397524547
// 스프링에서 response로 안드로이드 : https://loveiskey.tistory.com/190

@RestController
public class AndroidController {
	private static final Logger logger = LoggerFactory.getLogger(AndroidController.class);
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(value="/androidToServer", method=RequestMethod.POST)
	public String androidToServerMethod(@RequestBody UserVO vo) throws Exception {
		UserVO loginUser = uService.loginUser(vo);
		logger.info(vo.toString());
		
		if(loginUser == null) {
			return "NOK";
		}
		else {
			return "OK";
		}
	}
	
	@RequestMapping(value="/RegisterandroidToServer", method=RequestMethod.POST)
	public String androidToServerRegisterMethod(@RequestBody UserVO vo) throws Exception{
		int result = uService.userIdCheck(vo);
		
		// 아이디 중복이 없을 때
		if(result == 0) { 
			uService.addUser(vo);
			logger.info("regist User : "+vo.toString());
			return "OK";
		}
		// 아이디 중복 시
		
		logger.info("regist Error[Duplicate User ID] : "+vo.toString());

		return "NOK";
	}
}
