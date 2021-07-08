package com.kpu.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kpu.service.ImgResourceAccessService;

@Controller
public class SelectImageController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@Autowired
	private ImgResourceAccessService imgService;
	
	@RequestMapping(value="/selectImage", method=RequestMethod.GET)
	public String selectImage(@RequestParam("img") String img, Model model, HttpServletRequest request) throws Exception {
		List<String> fileNameList = imgService.ImgAccessService(uploadPath);
		
		model.addAttribute("fileList", fileNameList);
		model.addAttribute("img", img);
		
		return "selectImage";
	}
	
	@RequestMapping(value="/detectImage", method=RequestMethod.GET)
	public String detectImage(@RequestParam("img") String img, Model model, HttpServletRequest request) throws Exception {
		List<String> fileNameList = imgService.detectImgAccessService(detectPath);
		
		// 파일명만 저장된 리스트를 View에 전달하기 위한 모델 객체에 리스트 저장
		model.addAttribute("fileList", fileNameList);
		model.addAttribute("img", img);
		
		// detectImage view를 호출
		return "detectImage";
	}
	
}
