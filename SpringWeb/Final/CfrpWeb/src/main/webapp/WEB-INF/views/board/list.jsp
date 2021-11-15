<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:th="http://www.thymeleaf.org">

<head>
	<meta charset="UTF-8">
	<title>My detect Chart</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body> 
	<hr color="black"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
	
	<!-- style="width: 80%"  -->
	<div align="center">
		<div style="height:700px; width:1500px">
			<canvas id="canvas"></canvas>
			<!-- <canvas id="canvas" height="350" width="500"></canvas> -->
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
				<jsp:include page="/WEB-INF/views/sideView/sideBar.jsp"></jsp:include>
			</div>
			<div class="col-sm-8">
				<jsp:include page="/WEB-INF/views/sideView/header.jsp"></jsp:include>
				<br>
				
				<div align="center">
					<div class="w3-container">
						<div class="w3-panel" style="background-color:#EBEDEF">
							<p style="color:black; margin-top:7px">시간별 차트</p>
						</div>
						<div style="height:700px; width:800px">
							<canvas id="myCanvas"></canvas>
							
						</div>
					</div>
					<script type="text/javascript" src="<c:url value="/resources/js/myList.js"/>"></script>
					
				</div>
				<br><hr color="black"/>
				<jsp:include page="/WEB-INF/views/sideView/footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>
