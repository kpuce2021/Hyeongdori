package com.kpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value="/registerProcessing", method=RequestMethod.GET)
	public String registerGetMethod() throws Exception{
		return "userView/registerUser";
	}
}
