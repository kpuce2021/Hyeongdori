<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<div class="jumbotron well">
			<div class="text-center">
				<h1>Team Hyeongdori</h1>
			  	<p>한국 산업 기술대학교 컴퓨터공학부 졸업작품<br> 딥 러닝을 적용한 CFRP 가공 결함 검출 웹페이지 입니다.</p>
			  	<br>
			  	<p>
			  		<a class="btn btn-primary btn-lg" href="https://github.com/kpuce2021/Hyeongdori" role="button">
			  			<i class="fab fa-github-square" aria-hidden="true"></i>Our Github</a>
			  	</p>
			</div>
		</div>
		
		<!-- content -->
		<!-- container-fluid로 좌우로 꽉 찬 레이아웃을 만든다. -->
		<div class="container-fluid">
		    <div class="row">
		        <!-- left content -->
		       <div class="col-sm-3">
		           <!-- side menu (link) -->
		         <jsp:include page="/WEB-INF/views/sideBar.jsp"></jsp:include>
		       </div>
		    
		         <!-- right content -->
		    <div class="row">
			     <div class="col-sm-8">
			       <h2 class="front-italic">'딥러닝을 적용한 CFRP 가공 결함 검출'</h2>
			        <p class="front-italic">2020-01-10 ~ 2021-08-10</p>
			        <hr>
			        <!-- side menu (link) -->  
			        <jsp:include page="/WEB-INF/views/thumbnail.jsp"></jsp:include>
			         <!-- 넣고싶은 글 넣으면 됌  -->
			     </div>
		     </div>
		     </div>
		 </div>
		
		<hr color="black">
	</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
