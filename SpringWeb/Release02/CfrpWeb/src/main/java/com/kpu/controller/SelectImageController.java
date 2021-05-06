package com.kpu.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class SelectImageController {
	@RequestMapping(value="/selectImage")
	public String selectImage(Model model, HttpServletRequest request) {
		//File path = new File("C:/img/");
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		File path = new File(contextRoot+"/resources/img/");
		File[] fileList = path.listFiles();
		
		
		model.addAttribute("fileList", fileList);
		if(fileList.length > 0) {
			for(int i=0; i<fileList.length; i++) {
				System.out.println(fileList[i]);
			}
		}
		
		return "selectImage";
	}
}
