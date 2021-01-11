## 우분투 16ver에 JSP 개발환경 만들기   
### 출처 : [블로그](https://m.blog.naver.com/PostView.nhn?blogId=kgustaff&logNo=10136084011&proxyReferer=https:%2F%2Fwww.google.com%2F)   

***   
   

### 사전 준비   

  ** Tomcat 버전과 JDK 버전은 동일한 버전으로 설치한다.**   

  - Ubuntu Linux 16ver virtual machine   
  - Java JDK   
  - Eclipse   
  - Tomcat    
  - Apache   

#### JDK 1.8.0 설치   
  1. JDK, JRE 설치 명령어 실행   
      > **sudo apt-get install openjdk-8-jre**   
      > **sudo apt-get install openjdk-8-jdk**   
   
  2. 설치 확인   
      > **java -version**   
		terminal : openjdk version 1.8.0_131   
      > **javac -version**   
		terminal : javac 1.8.0_131   
   
  3. Default Java 선택(여러 자바가 설치되어 있을 때)   
      > **sudo update-alternatives --config java**   
		terminal : 설치된 자바 목록이 나옴   
   
  4. 자바 환경변수 설정   
      > **which javac**   
		terminal : /usr/bin/javac(javac 위치를 확인)   
      > **readlink -f /usr/bin/javac**   
		terminal : /usr/lib/jvm/java-8-openjdk-amd64/bin/javac -> javac의 실제 위치   
      > $JAVA_HOME은 /usr/lib/jvm/java-8-openjdk-amd64로 설정해야 함   
   
  5. 환경 변수 설정을 위해 profile을 편집한다.   
      > **sudo [editor 이름] /etc/profile**   

```java
	export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
	export PATH=$JAVA_HOME/bin/:$PATH
	export CLASS_PATH=$JAVA_HOME/lib:$CLASS_PATH
```   
  6. profile을 reload한다.   
      > **source /etc/profile**   
   
  7. 우분투 서버를 재시작   
      > **sudo reboot now**   
   
  8. 재시작 후 환경변수 확인   
      > **echo $JAVA_HOME**   
   
