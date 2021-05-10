package com.kpu.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.kpu.domain.ResponseEntityJson;


@Controller
public class FileController {
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	// Server에 클라이언트 로컬 이미지를 전송하기 위해 formFile View를 호출하는 컨트롤러 메서드
	@RequestMapping(value="/formFile")
	public String formFile() {
		return "formFile";
	}
	
	@RequestMapping(value="/testFile", method=RequestMethod.POST)
	public String testFile(MultipartFile uploadfile, Model model) throws IOException, InterruptedException {
		
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.jpg'").format(new Date());
		File saveFile = new File(uploadPath, fileName);
		uploadfile.transferTo(saveFile);
		System.out.println(fileName);
		
		
		String[] temp = fileName.split("\\."); // 스플릿으로 확장자 제거
	    String originFileName = temp[0]; // 제거된 고유 파일 이름만 저장
	    
	    ResponseEntityJson resEntity = new ResponseEntityJson();
	    
	    RestTemplate restTemplate = new RestTemplate();
	    resEntity = restTemplate.getForObject("http://3.37.42.228:8070/api?image="+originFileName, ResponseEntityJson.class);
	    
	    model.addAttribute("result", resEntity);
		// 결함종류, 개수를 사용자에게 보여줄 부분 작성해야 함
        return "view";
	}
	
	
}
