## CFRP Web Release 7

#### 2021-07-04 최종 수정

***

<br>

### Release 6에서 변경사항

- mybatis 연동을 위한 pom.xml 추가
- mapper 파일 작성
- DAO 설계
- 우분투에 배포된 상태
- 기존의 firebase db 삭제

<br>



### Release 6에서 에러사항

- spring-security 모듈 추가 시 AWS EC2 Ubuntu webapps 배포에서 404 에러
- 404 에러 이후 기존 pom.xml로 rollback해도 여전히 404 에러
- maven clean 이후 maven install을 이용하여 재 빌드해도 404 에러

