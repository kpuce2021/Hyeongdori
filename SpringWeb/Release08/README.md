## CFRP Web Release 8

#### 2021-07-06 최종 수정

***

<br>

### :pushpin: Release 7에서 변경사항

- spring-security의 404 error로 인해 Interceptor를 통한 로그인, 회원가입 구현
- mapper.xml에 회원가입을 위한 select query 추가(idChk)
- DAO 설계
  - public int idChk() 함수 추가
- Service 설계
  - public int userIdCheck() 함수 추가
- JSP
  - registerUser.jsp에 회원가입에 사용될 javascript 구문 추가
    - 모든 form 내용을 입력해야 회원가입 가능
      - 하나라도 미입력 시 alert 메시지와 함께 해당 form 내용에 focusing
    - id 중복 체크를 검사해야 회원가입 가능
    - Cancle(취소) 버튼 추가
  - header 의 변경사항
    - 사용자 로그인 시 사용자의 id 표시

<br>

### :pushpin: Release 7에서 에러사항

- spring-security 404 error
- 로그인 시 alert 메시지 출력 불가
- 로그인 시 유효한 id, password가 아니면 alert 메시지 출력 불가
- 미 로그인 시 메뉴 이용 불가 alert 메시지 출력 불가

<br>

### :pushpin: Release 9에서 기대사항

- DoS, DDoS 공격을 대비한 우분투 iptables 설정
- Release 7에서의 에러사항 해결
- 차트 분석을 위한 사용자별 이미지 이름, 검출 결과를 My-SQL에 저장
- 로그인, 회원가입 시 alert 출력 불가 해결
- 앱과 My-SQL연동을 위한 페이지 구현

