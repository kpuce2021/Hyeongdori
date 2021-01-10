## Ubuntu 16ver에 Tomcat 설치 및 실행   
***   
### 출처 : [영준의 개발 블로그](http://june0313.github.io/2018/05/22/install-tomcat-on-ubuntu/)   



#### 서버 기능   
  1. 사용자에게 검출 결과를 보여줄 JSP 페이지, JSP 페이지를 서비스해줄 **톰캣 서버**가 필요하다.   
  2. 입력 이미지와 출력 이미지를 저장하기 위한 **Input Storage**, **Output Storage**가 필요하다.   
  3. **Input Storage**, **Output Storage**와 연동되어 상호작용을 하기 위한 서버 내 **가공 결함 검출 프로그램**이 필요하다.   
  4. **Input Storage**에 입력된 새로운 이미지를 **AWS의 Deep Learning EC2 Server**에 전송해야 한다.   
  5. **AWS의 Deep Learning EC2 Server**에서 검출된 가공 결함을 **가공 결함 검출 프로그램**에 전송해야 한다.   
  6. **가공 결함 검출 프로그램**은 결과 이미지를 **Output Storage**에 저장해야 한다.   
  7. **Tomcat 서버**는 JSP 페이지에 **Output Storage**에 이미지를 주기적으로 사용자에게 보여줘야 한다.   

#### Ubuntu에 Tomcat 서버 설치   
  - 방식   
      1. apt-get 명령어 사용 방식   
      2. wget 명령어 사용 방식   

#### 해당 블로그에서 다루는 방식은 톰캣 압축파일을 직접 다운로드 하여 설치하는 방식(wget)   
  - 절차   
      1. 아파치 톰캣 홈페이지에 방문하여 다운로드할 톰캣 압축 파일의 URL 경로를 획득한다.   
          [Tomcat Homepage](http://tomcat.apache.org/)   
          > 9버전 기준으로 진행   

      2. Download Tab -> Tomcat 9 **Click** -> Binary Distributions 섹션에서 Core에 해당하는 tar.gz 파일을 
      우클릭 해서 링크 주소를 복사   
          > ex) http://mirror.apache-kr.org/tomcat/tomcat-9/v9.0.8/bin/apache-tomcat-9.0.8.tar.gz   

      3. wget 명령어를 사용하여 웹상의 파일을 다운로드   
          > ex) wget http://mirror.apache-kr.org/tomcat/tomcat-9/v9.0.8/bin/apache-tomcat-9.0.8.tar.gz   

      4. 다운로드 완료 후 **apache-tomcat-9.0.8.tar.gz** 파일이 생성된 것을 확인   

      5. 압축 파일 해제   
          > ex) tar -zvxf **apache-tomcat-9.0.8.tar.gz**   

      6. 톰캣 서버 실행 시 **apache-tomcat-9.0.8/bin/** 디렉토리 밑에 **startup.sh** 파일을 실행한다.   
          > ex) 해당 경로로 이동 후 ./startup.sh 명령어 사용   
          > Tomcat은 기본적으로 **8080**, **8005**, **8009** 3개의 포트로 설정되어 있기 때문에 우분투 서버의 8080 포트로 접속하여<br> 톰캣 서버가 정상 실행중인지 확인   
          > Tomcat 홈페이지가 표시되면 정상적으로 실행된 것을 확인할 수 있다.   
          > **netstat -nlp** 명령을 이용하여 톰캣 서버가 실행중인지 확인 가능   

      7. 톰캣 서버 종료   
          > **apache-tomcat-9.0.8/bin/** 디렉토리 밑에 **shutdown.sh** 파일을 실행   
