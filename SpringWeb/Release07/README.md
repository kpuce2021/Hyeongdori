## CFRP Web Release 7

#### 2021-07-04 최종 수정

***

<br>

### Release 6에서 변경사항

- mybatis 연동을 위한 pom.xml 추가
- mapper 파일 작성
  - 로그인, 회원가입을 위한 Query
- DAO 설계
  - 로그인, 회원가입을 위한 My-SQL 접근
- 우분투에 배포된 상태
- 기존의 firebase db 삭제
- Spring Interceptor 구현(AuthenticationInterceptor)
  - 세션이 null 상태일 때, 왼쪽의 메뉴 배너 클릭 시 로그인 유도
  - 세션이 null 상태가 아닐 때, 왼쪽의 메뉴 배너 이용 가능
  - 세션의 유지 시간은 30분

<br>



### Release 6에서 에러사항

- spring-security 모듈 추가 시 AWS EC2 Ubuntu webapps 배포에서 404 에러
- 404 에러 이후 기존 pom.xml로 rollback해도 여전히 404 에러
- maven clean 이후 maven install을 이용하여 재 빌드해도 404 에러

