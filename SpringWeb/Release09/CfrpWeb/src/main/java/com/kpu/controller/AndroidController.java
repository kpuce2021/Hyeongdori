package com.kpu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 안드로이드 스프링 Mysql 연동 : https://m.blog.naver.com/rhrkdfus/221397524547
// 스프링에서 response로 안드로이드 : https://loveiskey.tistory.com/190

@Controller
public class AndroidController {
	@RequestMapping(value="/androidToServer", method=RequestMethod.POST)
	public Map<String, String> androidToServerMethod(HttpServletRequest request, Model model) {
		try {
			String And_id = request.getParameter("id");
			String And_passwd = request.getParameter("passwd");
			Map<String, String> result = new HashMap<String, String>();
			result.put("id", And_id);
			result.put("passwd", And_passwd);
			
			model.addAttribute("android_id", And_id);
			model.addAttribute("android_passwd", And_passwd);
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
