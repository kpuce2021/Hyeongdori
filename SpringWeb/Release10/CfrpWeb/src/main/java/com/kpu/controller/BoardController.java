//boardController
package com.kpu.controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kpu.domain.ResultVO;
import com.kpu.domain.UserVO;
import com.kpu.service.ResultService;


// Controller의 역할 : url을 Mapping 시킨다.

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@Autowired
	private ResultService rService;
	
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
		
		Collections.sort(fileNameList);
		Collections.reverse(fileNameList);
		
		List<String> resultList = new ArrayList<String>();
		
		int uncut = 0, spalling=0;
		
		for(int i=0; i<fileNameList.size(); i++) {
			File file = new File(fileNameList.get(i));
			
			try (BufferedReader br = new BufferedReader(new FileReader(file))){
					String line;
					while((line = br.readLine()) != null) {
						String[] temp = line.split(":");
						if(temp[0].equals("uncut")) {
							uncut += Integer.parseInt(temp[1]);
						}
						else if(temp[0].equals("spalling")) {
							spalling += Integer.parseInt(temp[1]);
						}
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
	
	@RequestMapping(value="myDetectList", method=RequestMethod.GET)
	public String myDetectListMethod(@RequestParam("img") String img, HttpSession session, Model model) throws Exception{
		UserVO user = (UserVO)session.getAttribute("login"); // 현재 사용자의 세션을 받아온다.
		 
		List<String> resultImgNameList = rService.readImgNameListByUserId(user.getId());
		
		model.addAttribute("resultList", resultImgNameList);
		model.addAttribute("img", img);
		return "board/myDetectList";
	}
	
}
