package com.kpu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectImageController {
	@RequestMapping(value="/selectImage")
	public String selectImage() {
		return "selectImage";
	}
}
