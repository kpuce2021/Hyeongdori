package com.kpu.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.kpu.domain.ResponseEntityJson;
import com.kpu.domain.ResultVO;
import com.kpu.domain.UserVO;
import com.kpu.service.ResultService;
import com.kpu.service.UserService;


@Controller
public class FileController {
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@Autowired
	private ResultService rService;
	
	// Server에 클라이언트 로컬 이미지를 전송하기 위해 formFile View를 호출하는 컨트롤러 메서드
	@RequestMapping(value="/formFile")
	public String formFile() {
		return "formFile";
	}
	
	@RequestMapping(value="/webToServer", method=RequestMethod.POST)
	public String imageTransferMethod(MultipartFile uploadfile, Model model, HttpSession session, ResultVO rVO) throws Exception {
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.jpg'").format(new Date());
		File saveFile = new File(uploadPath, fileName);
		uploadfile.transferTo(saveFile);
		
		UserVO user = (UserVO) session.getAttribute("login");
		rVO.setId(user.getId());
		// 사용자 id, 이미지 originFileName, uncut, spalling을 컬럼으로 사용
		
		String[] temp = fileName.split("\\."); // 스플릿으로 확장자 제거
	    String originFileName = temp[0]; // 제거된 고유 파일 이름만 저장
	    rVO.setImgName(fileName);
	    
	    ResponseEntityJson resEntity = new ResponseEntityJson();
	    
	    RestTemplate restTemplate = new RestTemplate();
	    resEntity = restTemplate.getForObject("http://3.34.77.179:8070/api?image="+originFileName, ResponseEntityJson.class);
	    
	    File file = new File(detectPath+originFileName+".txt");
	    
	    try(BufferedReader br = new BufferedReader(new FileReader(file))){
	    	String line;
	    	while((line = br.readLine()) != null) {
	    		String[] flaw = line.split(":");
	    		if(flaw[0].equals("uncut")) {
	    			rVO.setUncut(flaw[1]);
	    		}
	    		else if(flaw[0].equals("spalling")) {
	    			rVO.setSpalling(flaw[1]);
	    		}
	    	}
	    }
	    catch(IOException e) {
	    	e.printStackTrace();
	    }
	    
	    rService.addResultService(rVO); // DB에 사용자 정보 저장
	    
	    model.addAttribute("ResultVO", rVO);
	    model.addAttribute("result", resEntity);
		// 결함종류, 개수를 사용자에게 보여줄 부분 작성해야 함
        return "userView/view";
	}
	
	@RequestMapping(value="/viewImage", method=RequestMethod.GET)
	public String viewImageMethod(@RequestParam("img") String img, Model model) throws Exception{
		model.addAttribute("img", img);
		return "viewImage";
	}
	
}
