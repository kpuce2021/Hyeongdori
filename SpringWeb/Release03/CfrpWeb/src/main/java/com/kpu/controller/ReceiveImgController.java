package com.kpu.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.jsp.PageContext;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
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
import com.kpu.domain.ResponseEntityJson;

@RestController
@RequestMapping(value="/receive")
public class ReceiveImgController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name="detectPath")
	private String detectPath;
	
	@RequestMapping(value="receiveImage", method = RequestMethod.POST)
	public ResponseEntityJson receiveImage(@RequestParam("image") String ImgUrl, HttpServletRequest request) throws IOException, InterruptedException {
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.jpg'").format(new Date());
		byte[] decodedByte = Base64.getMimeDecoder().decode(ImgUrl);
		
		
		// 새로 테스트해볼코드
		
		//String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/"); 
		//String attach_path = "resources/img/";
		
		// 리눅스 경로상 /var/lib/tomcat9/webapps/upload에 저장된다.
		
		Files.write(Paths.get(uploadPath+fileName), decodedByte);

		ResponseEntityJson resEntity = new ResponseEntityJson(); // json형태로 보낼 객체 선언
		String[] temp = fileName.split("\\."); // 스플릿으로 확장자 제거
	    String originFileName = temp[0]; // 제거된 고유 파일 이름만 저장

	    /*
	    String[] command = new String[4];
	    command[0] = "python3";
	    command[1] = "/home/ubuntu/yolov5/detect.py";
	    command[2] = uploadPath+fileName;
	    try {
	    	CommandLine commandLine = CommandLine.parse(command[0]);
	    	for(int i=1, n=command.length; i<n;i++) {
	    		commandLine.addArgument(command[i]);
	    	}
	    	
	    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    	PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
	    	DefaultExecutor executor = new DefaultExecutor();
	    	executor.setStreamHandler(pumpStreamHandler);
	    	int python_result = executor.execute(commandLine);
	    }
	    
	    */
	   
	    
		Process p = Runtime.getRuntime().exec("python3 /home/ubuntu/yolov5/detect.py —source " + uploadPath+"202105061557.jpg");
        p.waitFor();
        p.destroy();
		

	    
        BufferedReader br = new BufferedReader(new FileReader(detectPath+"202105061557.txt"));
        int count = 0;
        String result = "";

        while(true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break;
            count++;

            String[] strArr = line.split(":");
            String name = strArr[0]; // 결함 이름
            String n = strArr[1]; // 결함 개수
            result += name + ": " + n;
        }
        if (count == 0) {
            result = "결함 없음";
        }
        br.close();

	
		
        resEntity.setResult(result);
        resEntity.setUrl("http://3.34.46.163:8080/detect/" + "202105061557.jpg");
        
		// 기존 코드
		//Files.write(Paths.get("c:/test/"+fileName), decodedByte);
		
		return resEntity;
	}
	
	/*
	// formFile에서 이미지 선택, 아래 메서드에 MultipartFile 객체에 저장
	// 해당 객체에 오리진 파일 네임을 안드로이드에 리턴해주면 된다.
	@RequestMapping(value="/FileToAndroid", method=RequestMethod.POST)
	public String returnImage(@RequestParam(value="img") MultipartFile uploadfile, Model model, MultipartHttpServletRequest request) throws IOException {
		System.out.println(uploadfile.getOriginalFilename());

		
		// 리소스에 파일 저장, 새로 추가한 부분
		String path1 = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "resources/img/";
		String file_name = uploadfile.getOriginalFilename();
		System.out.println("root path : " +path1+attach_path+file_name);
		

		File f = new File(path1+attach_path+file_name);
		uploadfile.transferTo(f); // 파일 저장 
		System.out.println(request.getContextPath());
		return "redirect:/view";
	}
	*/
	@RequestMapping(value="/FileToAndroid", method=RequestMethod.POST)
	public String returnImage(@RequestParam(value="img") MultipartFile uploadfile, Model model, HttpServletRequest request) throws IOException {
		System.out.println(uploadfile.getOriginalFilename());

		
		String str = request.getContextPath();
		System.out.println(str);
		return "oj";
	}
	
	
	
}
