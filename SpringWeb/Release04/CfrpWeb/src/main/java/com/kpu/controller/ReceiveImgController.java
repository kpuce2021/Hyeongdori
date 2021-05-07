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
		
		// 앱으로부터 전송받은 파일 이름은 년도/월/일/시/분.jpg 형태로 저장한다.
		// 파일명 생성
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.jpg'").format(new Date());
		
		// 앱으로부터 전송받은 이미지 string을 바이트 코드로 디코딩 수행
		byte[] decodedByte = Base64.getMimeDecoder().decode(ImgUrl);
		
		// uploadPath : /var/lib/tomcat9/webapps/upload/
		// 바이트 코드로 디코딩된 이미지 파일을 Files 객체를 사용하여 명시된 경로에 저장한다.
		Files.write(Paths.get(uploadPath+fileName), decodedByte);

		// 앱에서 받은 검출 전 이미지를 파이썬 프로그램을 통해 검출 후 결과를 전송하기 위한 객체
		// string형 변수인 url, result가 존재한다.
		// url : 서버의 detect 폴더에 이미지를 url 경로로 보내주기 위함
		// result : 결함의 종류와 개수를 알려주기 위함 
		ResponseEntityJson resEntity = new ResponseEntityJson(); // json형태로 보낼 객체 선언
		
		// detect 폴더 내 검출된 이미지에 jpg 파일을 추출하기 위한 코드 
		// 파이썬 코드 실행 후 검출 결과 jpg, txt 파일은 원본의 파일명과 동일하게 detect 폴더에 저장된다.
		String[] temp = fileName.split("\\."); // 스플릿으로 확장자 제거
	    String originFileName = temp[0]; // 제거된 고유 파일 이름만 저장

	    /*
	     * 시도해볼 코드
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
	   
	    // 앱에서 전송한 사진의 결함을 검출하기 위해 yolov5 실행하는 코드
		Process p = Runtime.getRuntime().exec("python3 /home/ubuntu/yolov5/detect.py —source " + uploadPath+"202105061557.jpg");
        p.waitFor();
        p.destroy();
		
        // detectPath : /var/lib/tomcat9/webapps/detect/
        // 파이썬 프로그램 실행 후 detect 파일에 저장된 결함 검출 후 해당 이미지에 대한 검출 결과 txt 파일을 읽는다.
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

	
		// ResponseEntityJson 객체의 url, result 변수를 세팅하는 코드
        resEntity.setResult(result); // 결함의 종류, 개수가 명시된 result 세팅
        resEntity.setUrl("http://3.34.46.163:8080/detect/" + "202105061557.jpg"); // 결함 검출 사진 URL 세팅
	
        // ResponseEntityJson 객체 반환
		return resEntity;
	}
	
	
	// formFile View에서 사용자에 의해 호출되는 컨트롤러
	// img라는 이름으로 MultipartFile 형태의 이미지가 해당 메서드로 전송된다.
	@RequestMapping(value="/LocalToServer", method=RequestMethod.POST)
	public String returnImage(@RequestParam(value="img") MultipartFile uploadfile, Model model, HttpServletRequest request) throws IOException, InterruptedException {
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.jpg'").format(new Date());
		Files.write(Paths.get(uploadPath+fileName), uploadfile.getBytes());
		System.out.println(fileName);
		String[] temp = fileName.split("\\."); // 스플릿으로 확장자 제거
	    String originFileName = temp[0]; // 제거된 고유 파일 이름만 저장
	    
	    Process p = Runtime.getRuntime().exec("python3 /home/ubuntu/yolov5/detect.py —source " + uploadPath+fileName);
        p.waitFor();
        p.destroy();
	    
        BufferedReader br = new BufferedReader(new FileReader(detectPath+originFileName+".txt"));
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
        
		// 결함종류, 개수를 사용자에게 보여줄 부분 작성해야 함
        
		return "oj";
	}
	
	
	
}
