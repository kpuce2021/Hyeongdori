//boardController
package com.kpu.controller;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		// 각 사용자별 결함 검출 결과를 DB에서 가져와서 차트로 그려주기
		return "board/list"; 
	}
	
	@RequestMapping(value="myDetectList", method=RequestMethod.GET)
	public String myDetectListMethod(@RequestParam("img") String img, HttpSession session, Model model) throws Exception{
		UserVO user = (UserVO)session.getAttribute("login"); // 현재 사용자의 세션을 받아온다.
		 
		List<String> resultImgNameList = rService.readImgNameListByUserId(user.getId());
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		
		Collections.sort(resultImgNameList);
		Collections.reverse(resultImgNameList);
		
		for(String item : resultImgNameList) {
			linkedHashSet.add(item);
		}
		
		
		model.addAttribute("resultList", linkedHashSet);
		model.addAttribute("img", img);
		return "board/myDetectList";
	}
	
}
