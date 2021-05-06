package com.kpu.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kpu.domain.ImageVO;

@RestController
@RequestMapping(value="/receive")
public class ReceiveImgController {
	
	@RequestMapping(value="receiveImage", method = RequestMethod.POST)
	public String receiveImage(@RequestParam("image") String ImgUrl, MultipartHttpServletRequest request) throws IOException {
		System.out.println(ImgUrl);
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.jpg'").format(new Date());
		byte[] decodedByte = Base64.getMimeDecoder().decode(ImgUrl);
		
		// 새로 테스트해볼코드
		String path1 = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "resources/img/";
		Files.write(Paths.get(path1+attach_path+fileName), decodedByte);

		// 요까지
		
		// 기존 코드
		//Files.write(Paths.get("c:/test/"+fileName), decodedByte);
		
		return "Complete";
	}
	
	
	// formFile에서 이미지 선택, 아래 메서드에 MultipartFile 객체에 저장
	// 해당 객체에 오리진 파일 네임을 안드로이드에 리턴해주면 된다.
	@RequestMapping(value="/FileToAndroid", method=RequestMethod.POST)
	public String returnImage(@RequestParam(value="img") MultipartFile uploadfile, MultipartHttpServletRequest request) throws IOException {
		System.out.println(uploadfile.getOriginalFilename());

		// 리소스에 파일 저장, 새로 추가한 부분
		String path1 = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "resources/img/";
		String file_name = uploadfile.getOriginalFilename();
		System.out.println("root path : " +path1+attach_path+file_name);
		
		File f = new File(path1+attach_path+file_name);
		uploadfile.transferTo(f); // 파일 저장 
		return "OK";
	}
	
}
