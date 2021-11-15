//boardController
package com.kpu.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.kpu.domain.ResultDayVO;
import com.kpu.domain.ResultVO;
import com.kpu.domain.UserVO;
import com.kpu.service.ImgResourceAccessService;
import com.kpu.service.ResultService;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@Autowired
	private ResultService rService;
	
	@RequestMapping(value="/allList", method=RequestMethod.GET)
	public String allListViewMethod(Model model) throws Exception{
		List<ResultDayVO> rdVO = rService.readAllImgNameByDay();
		model.addAttribute("days", rdVO);
		return "board/allList";
	}
	
	@RequestMapping(value="/charByDay", method=RequestMethod.GET, produces="text/plain; chartset=UTF-8")
	public @ResponseBody String chartByDayMethod() throws Exception{
		List<ResultDayVO> rdVO = rService.readAllImgNameByDay();
		
		Gson gson = new Gson();
		return gson.toJson(rdVO);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listViewMethod() throws Exception{
		return "board/list";
	}
	
	@RequestMapping(value="/allListData", method=RequestMethod.GET, produces="text/plain; charset=UTF-8")
	public @ResponseBody String allListMethod() throws Exception{
		List<ResultVO> rList = rService.readAllUserList();
		
		for(int i=0; i<rList.size(); i++) {
			String[] temp = rList.get(i).getImgName().split("\\.");
			rList.get(i).setImgName(temp[0]);
		}
		
		Gson gson = new Gson();
		
		return gson.toJson(rList);
	}
	
	@RequestMapping(value="/listData", method=RequestMethod.GET, produces="text/plain; charset=UTF-8")
	public @ResponseBody String list(HttpSession session, UserVO uVO, ResultVO rVO, Model model) throws Exception {
		uVO = (UserVO)session.getAttribute("login");
		List<ResultVO> rList = rService.readAllByUserId(uVO.getId());
		
		
		for(int i=0; i<rList.size(); i++) {
			String[] temp = rList.get(i).getImgName().split("\\.");
			rList.get(i).setImgName(temp[0]);
		}
		
		Gson gson = new Gson();
		
		return gson.toJson(rList); 
	}
	
	  @RequestMapping(value="/chartByMonth", method=RequestMethod.GET, produces="text/plain; chartset=UTF-8")
	   public @ResponseBody String chartByMonthMethod() throws Exception{
	      List<ResultDayVO> rdVO = rService.readAllImgNameByMonth();
	      
	      Gson gson = new Gson();
	      return gson.toJson(rdVO);
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
