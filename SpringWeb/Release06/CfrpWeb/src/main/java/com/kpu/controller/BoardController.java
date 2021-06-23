package com.kpu.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



// Controller의 역할 : url을 Mapping 시킨다.

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		File path = new File(detectPath);
		File[] fileList = path.listFiles();
		List<String> fileNameList = new ArrayList<String>();
		
		if(fileList.length > 0) {
			for(int i=0; i<fileList.length; i++) {
				String[] temp = fileList[i].getName().split("\\.");
				if(!temp[1].equals("jpg")) {
					// 뒤에가 .txt인 파일들만 fileNameList에 넣는다.
					fileNameList.add(detectPath+fileList[i].getName());
				}
			}
		}
		
		List<String> resultList = new ArrayList<String>();
		
		for(int i=0; i<fileNameList.size(); i++) {
			File file = new File(fileNameList.get(i));
			
			try (BufferedReader br = new BufferedReader(new FileReader(file))){
					String line;
					while((line = br.readLine()) != null) {
						resultList.add(line);
					}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileNameList", fileNameList);
		model.addAttribute("resultList", resultList);
		return "board/list"; 
	}
	
	
}
