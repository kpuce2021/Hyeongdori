<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>CFRP :: Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="css/login.css">
   <link rel="icon" href="image/favicon.png">
</head>
<body>
   <!-- header -->
   <div class="jumbotron text-center mb-0">
      <h1>CFRP</h1>
      <p>CFRP 가공 결함 검출 페이지</p>
   </div>
   <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <!-- 리스트 : 부트스트랩은 모바일 우선이라 화면이 작으면 아래로 쌓아서 내려온다 -->
      <ul class="navbar-nav navbar-dark">
         <li class="nav-item active"><a class="nav-link" href="main.jsp">HOME</a></li>
      </ul>
      <!-- Search -->
      <form class="form-inline ml-auto" action="">
      
         <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav navbar-dark">
	      		 <li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
	        	 <li class="nav-item"><a class="nav-link" href="#">CFRP 소개</a></li>
	        	 <li class="nav-item dropdown">
	            	<!-- 드롭다운 메뉴-->
			          <a class="nav-link dropdown-toggle" href="#"
			            data-toggle="dropdown"> 관련 기술 </a>
			            
			            <div class="dropdown-menu">
			               <a class="dropdown-item" href="#">이미지 전처리</a> 
			               <a class="dropdown-item" href="#">딥 러닝</a> 
			               <a class="dropdown-item" href="#">웹 페이지 개발</a>
	           			</div>
	         	</li>
        	</ul>
         </nav>
         
         <!-- inline여야 간격이 없이 메뉴처럼 나온다. ml-atuo : 우측으로 붙게하기-->
         <input class="form-control mr-sm-2" type="text" placeholder="Search">
         <!-- form-control 입력창 꾸며주는 클래스 -->
         <button class="btn btn-success" type="submit">Search</button>
      </form>
   </nav>
  
         
   		
         
          <!-- content -->
   <div class="container pt-3">
      <div class="row">
         <!-- left content -->
         <div class="col-sm-3">

         
             <table>
                 <tr>
                     <td>
                <span style = "font-size:1.0em;  color: black; margin:4px">
    	            
	            </span>
                     </td>
                 </tr>
             </table>
             
            <!-- side menu (link) -->
            <%@include file="sidebar.jsp" %>
         </div>
         <!-- right content -->
         <div class="col-sm-8">
            <h2 class="front-italic">'딥러닝을 적용한 CFRP 가공 결함 검출'</h2>
            <p class="front-italic">2020-01-10 ~ 2021-08-10</p>
            <hr>
            <!-- side menu (link) -->
            <h3>주제</h3>
            <p>가공 결함 분석을 통한 가공 후처리 데이터 습득 프로세스 구축</p>
            
            <div class="text-center">
            </div>
             <!-- 넣고싶은 글 넣으면 됌  -->
         </div>
      </div>
      <hr>
   </div>
   <!-- footer -->
   <jsp:include page="footer.jsp" />

</body>
</html>