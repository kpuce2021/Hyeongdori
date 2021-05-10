## CFRP Web Release 5

2021-05-11 최종 수정

***

<br>  

### Release 4에서 바뀐점

- Spring Web에서 Python Program(Yolov5 detect.py) 실행 가능
- 앱에서 수신받은 이미지를 Python Program에 Rest Template으로 전송
  - getForObject 메서드를 통해 전송
  - getForObject에 URL과 반환형인 ResponseEntityJson Class로 전송
- 웹 브라우저에서 웹 서버로 결함 검출 전 이미지 전송 가능
  - formFile.jsp에서 선택한 이미지를 웹 서버에 전송
  - 전송된 이미지는 Python 프로그램을 통해 결함이 검출됨
  - 결함 검출 결과 jpg와 txt는 /var/lib/tomcat9/webapps/detect/ 폴더에 저장됨

<br>



### 변경된 부분

![결함검출](https://user-images.githubusercontent.com/55940552/117693232-c466a880-b1f8-11eb-9ade-807f2d726bb2.png)  

