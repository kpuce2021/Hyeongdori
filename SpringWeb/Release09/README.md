## CFRP Web Release 9

#### 2021-07-06 최종수정

***

<br> 

### :pushpin: Release 8에서 변경사항

- **로그인 alert 메시지 출력**
  - 로그인 성공 메시지
  - 로그인 실패 메시지
  - 미 로그인 시 메뉴 접근 불가 메시지
- **회원가입 alert 메시지 출력**
  - 아이디 중복 체크 시
    - 사용 가능한 아이디 출력
    - 사용 불가 아이디 출력
  - 아이디 중복 체크 미클릭 시 제출 불가 메시지 출력
  - form 내용 미입력 시 해당 form 내용으로 focusing
- **ScriptUtils Java Class 사용**
  - 출처 : [블로그](https://redcoder.tistory.com/195) 
- **Transaction 처리**
  - select query를 사용하는 Service 메서드에 readOnly=true(읽기 전용)를 설정하여<br> 성능을 최적화, 예상치 못한 엔티티의 등록, 변경, 삭제를 예방
  - 읽기 전용은 영속성 컨텍스트이므로 스냅샷을 보관하지 않기 때문에 메모리 사용량을<br> 최적화할 수 있다.
  - **readOnly=true 옵션 사용 시**
    - 스프링 프레임워크가 hibernate session flush 모드를 manual로 설정
    - 강제로 flush 호출하지 않는 한 flush가 일어나지 않음
    - 트랜잭션 커밋 시 영속성 컨텍스트가 flush 되지 않아서 엔티티 등록, 수정, 삭제<br> 가 동작하지 않는다.
    - 변경 감지를 위한 스냅샷 비교와 같은 무거운 로직들이 수행되지 않아 성능이 향상된다.

<br>

### :pushpin: Release 9 에러사항

- AOP를 통한 로그 출력
- Android To Server 컨트롤러에서 Post 방식의 요청이 불가 

<br>



### :pushpin: Release 10 기대사항

-  Android와 Spring 간의 My SQL DB를 활용한 로그인, 회원가입 구현
- AOP 로그 출력문제 해결