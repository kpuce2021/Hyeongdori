package com.kpu.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.kpu.domain.ResponseEntityJson;

@RestController
@RequestMapping(value="/receive")
public class ReceiveImgController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@RequestMapping(value="receiveImage", method = RequestMethod.POST)
	public ResponseEntityJson receiveImage(@RequestParam("image") String ImgUrl) throws IOException, InterruptedException {
		
		/* 
		 앱으로부터 전송받은 파일 이름은 년도/월/일/시/분.jpg 형태로 저장한다.
		 파일명 생성
		*/
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.jpg'").format(new Date());
		
		// 앱으로부터 전송받은 이미지 string을 바이트 코드로 디코딩 수행
		byte[] decodedByte = Base64.getMimeDecoder().decode(ImgUrl);
		
		// uploadPath : /var/lib/tomcat9/webapps/upload/
		// 바이트 코드로 디코딩된 이미지 파일을 Files 객체를 사용하여 명시된 경로에 저장한다.
		Files.write(Paths.get(uploadPath+fileName), decodedByte);

		/* 
		   앱에서 받은 검출 전 이미지를 파이썬 프로그램을 통해 검출 후 결과를 전송하기 위한 객체
		   string형 변수인 url, result가 존재한다.
		   url : 서버의 detect 폴더에 이미지를 url 경로로 보내주기 위함
		   result : 결함의 종류와 개수를 알려주기 위함 
		*/ 
		ResponseEntityJson resEntity = new ResponseEntityJson(); // json형태로 보낼 객체 선언
		
		/*
		 * detect 폴더 내 검출된 이미지에 jpg 파일을 추출하기 위한 코드 
		 * 파이썬 코드 실행 후 검출 결과 jpg, txt 파일은 원본의 파일명과 동일하게 detect 폴더에 저장된다.
		 * */
		String[] temp = fileName.split("\\."); // 스플릿으로 확장자 제거
	    String originFileName = temp[0]; // 제거된 고유 파일 이름만 저장

	    // 앱에서 전송한 사진의 결함을 검출하기 위해 yolov5 실행하는 코드
	    // AWS 서버의 파이썬 서버에 앱으로부터 전송받은 이미지를 전송하여 결과에 대한 json 형식의 객체를 ResponseEntityJson 클래스 객체에 받는다.
	    RestTemplate restTemplate = new RestTemplate();
	    resEntity = restTemplate.getForObject("http://3.37.42.228:8070/api?image="+originFileName, ResponseEntityJson.class);
	    
        // ResponseEntityJson 객체 반환
		return resEntity;
	}
}
