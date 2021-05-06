package com.kpu.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class SelectImageController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@RequestMapping(value="/selectImage")
	public String selectImage(Model model, HttpServletRequest request) {
		// File path = new File("C:/img/");
		//String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		//File path = new File(contextRoot+"/resources/img/");
		// /var/lib/tomcat9/webapp/detect/
		//File path = new File(detectPath);
		
		//System.out.println(path.getName());
		File path = new File(uploadPath);
		File[] fileList = path.listFiles();
		List<String> fileNameList = new ArrayList<String>();
		
		if(fileList.length > 0) {
			for(int i=0; i<fileList.length; i++) {
				System.out.println(fileList[i].getName());
				fileNameList.add(fileList[i].getName());
			}
		}
		model.addAttribute("fileList", fileNameList);
		
		return "selectImage";
	}
	
	@RequestMapping(value="/detectImage")
	public String detectImage(Model model, HttpServletRequest request) {
		File path = new File(detectPath);
		File[] fileList = path.listFiles();
		List<String> fileNameList = new ArrayList<String>();
		
		if(fileList.length > 0) {
			for(int i=0; i<fileList.length; i++) {
				String[] temp = fileList[i].getName().split("\\.");
				if(!temp[1].equals("txt")) {
					fileNameList.add(fileList[i].getName());
				}
			}
		}
		model.addAttribute("fileList", fileNameList);
		
		return "detectImage";
	}
	
}
