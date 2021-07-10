## CFRP Web Release 10

#### 2021-07-07 최종수정

***

<br>

### :pushpin: Release 9에서 변경사항

- RestController를 통한 앱, 웹 로그인, 회원가입 프로세스 추가
  - 앱에서 My SQL에 접근 가능한 Controller 추가
- 이미지 전송 이후 사용자별로 결함 검출 히스토리 확인 기능 추가
- 이미지 전송 시 사용자별로 DB에 자신의 히스토리 기록
- 사이드바 메뉴에 내 결과 확인 페이지 추가
- 사용자별 히스토리 보기 기능 추가
- 사용자별 히스토리 차트로 확인 기능 추가
- 회원탈퇴 및 내 정보 수정 기능 추가
- 사용자 내 정보 보기 기능 추가

<br> 

### :pushpin: MySQL 변경 사항

- result 테이블 생성
  - id, imgName, uncut, spalling에 대한 정보를 가지고 있다.
  - id는 user 테이블의 id를 참조하며, cascade 제약조건을 통해 user 테이블의 id가<br> 삭제될 시 result 테이블의 id에 대한 모든 정보도 삭제된다.

### :pushpin: Release 11 기대사항

- 사용자별 가공 결함 검출 결과에 대한 차트 분석 페이지 제공
- 이미지 프로세싱을 통한 가공 결함 촬영(안드로이드)



<br>

***

## 

### RestController 출처

[블로그](https://ecolumbus.tistory.com/4 ) 