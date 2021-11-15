<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:th="http://www.thymeleaf.org">

<head>
	<meta charset="UTF-8">
	<title>all detection Chart</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
				<jsp:include page="/WEB-INF/views/sideView/sideBar.jsp"></jsp:include>
			</div>
			<div class="col-sm-8">
				<jsp:include page="/WEB-INF/views/sideView/header.jsp"></jsp:include>
				<br>
				
				<div align="center">
					<div class="w3-container" style="margin-bottom:5px">
						<button onclick="myFunc('One')" class="w3-btn w3-round-large w3-block w3-center-align" style="background-color:#EBEDEF">
							시간별 차트 보기
						</button>
						<div id="One" class="w3-container w3-hide" style="margin-top:10px">
							<div style="height:500px; width:800px">
								<canvas id="canvas"></canvas>
							</div>
						</div>
						<script type="text/javascript" src="<c:url value="/resources/js/hourlyChart.js"/>"></script>
					</div>
					<div class="w3-container" style="margin-bottom:5px">
						<button onclick="myFunc('Two')" class="w3-btn w3-round-large w3-block w3-center-align" style="background-color:#EBEDEF">
							일자별 차트 보기
						</button>
						<div id="Two" class="w3-container w3-hide" style="margin-top:10px">
							<div style="height:500px; width:800px">
								<canvas id="canvas2"></canvas>
							</div>
						</div>
						<script type="text/javascript" src="<c:url value="/resources/js/chartByDay.js"/>"></script>
					</div>
					<div class="w3-container" style="margin-bottom:5px">
						<button onclick="myFunc('Three')" class="w3-btn w3-round-large w3-block w3-center-align" style="background-color:#EBEDEF">
							월별 차트 보기
						</button>
						<div id="Three" class="w3-container w3-hide" style="margin-top:10px">
							<div style="height:500px; width:800px">
								<canvas id="canvas3"></canvas>
							</div>
						</div>
						<script type="text/javascript" src="<c:url value="/resources/js/chartByMonth.js"/>"></script>
					</div>
					<script type="text/javascript" src="<c:url value="/resources/js/listAccordian.js"/>"></script>
					<!-- 
					<div class="w3-container">
						<div class="w3-panel" style="background-color:#EBEDEF">
							<p style="color:black; margin-top:7px">시간별 차트</p>
						</div>
						<div style="height:700px; width:800px">
							<canvas id="canvas"></canvas>
							
						</div>
					</div>
					<script type="text/javascript" src="<c:url value="/resources/js/hourlyChart.js"/>"></script>
					
					<div class="w3-container">
						<div class="w3-panel" style="background-color:#EBEDEF">
							<p style="color:black; margin-top:7px">일자별 차트</p>
						</div>

						<div style="height:700px; width:800px">
							<canvas id="canvas2"></canvas>
						</div>
					</div>
					<script type="text/javascript" src="<c:url value="/resources/js/chartByDay.js"/>"></script>
					
					<div class="w3-container">
						<div class="w3-panel" style="background-color:#EBEDEF">
							<p style="color:black; margin-top:7px">월별 차트</p>
						</div>
						<div style="height:700px; width:800px">
							<canvas id="canvas3"></canvas>
						</div>
					</div>
					<script type="text/javascript" src="<c:url value="/resources/js/chartByMonth.js"/>"></script> -->
				</div>
				<!-- footer -->
				<br><hr color="black"/>
				<jsp:include page="/WEB-INF/views/sideView/footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>
