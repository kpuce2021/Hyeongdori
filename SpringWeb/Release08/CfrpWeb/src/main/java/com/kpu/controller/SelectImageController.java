package com.kpu.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class SelectImageController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@RequestMapping(value="/selectImage", method=RequestMethod.GET)
	public String selectImage(@RequestParam("img") String img, Model model, HttpServletRequest request) {
		//File path = new File("C:/img/");
		
		/*
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		File path = new File(contextRoot+"/resources/img/");
		*/
		File path = new File(uploadPath); // 실제 사용 코드
		File[] fileList = path.listFiles();
		List<String> fileNameList = new ArrayList<String>();
		
		if(fileList.length > 0) {
			for(int i=0; i<fileList.length; i++) {
				System.out.println(fileList[i].getName());
				fileNameList.add(fileList[i].getName());
			}
		}
		
		Collections.sort(fileNameList);
		Collections.reverse(fileNameList);
		
		model.addAttribute("fileList", fileNameList);
		model.addAttribute("img", img);
		
		return "selectImage";
	}
	
	@RequestMapping(value="/detectImage", method=RequestMethod.GET)
	public String detectImage(@RequestParam("img") String img, Model model, HttpServletRequest request) {
		// detectPath : /var/lib/tomcat9/webapps/detect/
		// detectPath에 있는 모든 파일 목록 가져오기
		File path = new File(detectPath);
		File[] fileList = path.listFiles();
		
		// 현재 파일 목록은 절대 경로 + 파일명 형태로 명시되있음
		// jpg 파일만 가져오기 위한 String 형 리스트 선언
		List<String> fileNameList = new ArrayList<String>();
		
		// 절대경로 + 파일명에서 파일명만 추출하는 코드
		// 확장자를 확인해서 txt 파일들은 제외시킨다.
		if(fileList.length > 0) {
			for(int i=0; i<fileList.length; i++) {
				// split 함수로 확장자를 추출
				// temp[0]에는 파일명, temp[1]에는 확장자가 저장된다.
				String[] temp = fileList[i].getName().split("\\.");
				
				// 확장자가 txt가 아닌 경우
				if(!temp[1].equals("txt")) {
					// getName() 함수로 절대경로+파일명 파일리스트에서 파일명만 저장한다.
					fileNameList.add(fileList[i].getName());
				}
			}
		}
		Collections.sort(fileNameList);
		Collections.reverse(fileNameList);
		
		// 파일명만 저장된 리스트를 View에 전달하기 위한 모델 객체에 리스트 저장
		model.addAttribute("fileList", fileNameList);
		model.addAttribute("img", img);
		
		// detectImage view를 호출
		return "detectImage";
	}
	
}
