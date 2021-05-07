## CFRP Web Release 4

#### 2021-05-07 최종 수정 

***

<br> 

### Release 3에서 바뀐점

- 웹 서버에서 파이썬 프로그램(Yolo v5) 실행 방법 두 가지 제시
  - CommandLine 객체를 이용한 방법
  - Process 객체를 이용한 방법
- 클라이언트의 로컬 PC에 이미지를 웹 서버에 전송 후 웹 서버에서 EC2 서버 upload 디렉토리에 저장
- 웹 서버에서 EC2 서버 upload 디렉토리에 클라이언트 이미지를 결함 검출 후 View Layer를 통해 클라이언트에게 검출 결과 이미지 노출

<br>

### 컨트롤러

- **ReceiveImgController**(Rest 컨트롤러)
  - 앱에서 웹 서버에 이미지 전송 후 검출된 결과 이미지와 결함 개수 등을 리턴 받는다.
- **FileController**(일반 컨트롤러)
  - 클라이언트에서 웹 서버로 결함 검출 요청 시 필요한 View Layer인 formFile.jsp를 호출하는 메서드 존재
- **SelectImageController**(일반 컨트롤러)
  - 결함 검출 전 이미지들을 보여주는 컨트롤러 메서드
    - **/var/lib/tomcat9/webapps/upload/** 디렉터리에 검출 전 이미지들이 존재
  - 결함 검출 후 이미지들을 보여주는 컨트롤러 메서드
    - **/var/lib/tomcat9/webapps/detect/** 디렉터리에 검출 후 결과 이미지들이 존재

<br>

### 웹 서버에서 파이썬 프로그램(Yolo v5) 실행 방법 두 가지 제시

- **ReceiveImgController**(Rest 컨트롤러)

  1. CommandLine 객체를 이용한 파이썬 프로그램 실행

     ```java
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
     ```

     

  2. Process 객체를 이용한 파이썬 프로그램 실행

     ```java
     Process p = Runtime.getRuntime().exec("python3 /home/ubuntu/yolov5/detect.py —-source " + uploadPath+"검출 대상 이미지 이름.jpg");
             p.waitFor();
             p.destroy();
     ```

     

