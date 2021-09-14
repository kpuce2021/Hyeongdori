<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:th="http://www.thymeleaf.org">

<jsp:include page="/WEB-INF/views/sideView/header.jsp"></jsp:include>

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
	<hr color="black"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
				<jsp:include page="/WEB-INF/views/sideView/sideBar.jsp"></jsp:include>
			</div>
			<div class="col-sm-8">
				<div align="center">
					<br>
					<div class="w3-container">
						<c:forEach var="day" items="${days}">
							<button class="w3-btn w3-round-large w3-black" style="margin-right:5px">${day.days}</label>
						</c:forEach>
					</div>
					<br>
					<hr style="height:3px;border-width:0;color:white;background-color:white"><br>
					
					<div class="w3-container">
						<div class="w3-panel w3-gray">
							<p>시간별 차트</p>
						</div>
						<div style="height:700px; width:800px">
							<canvas id="canvas"></canvas>
							<!-- <canvas id="canvas" height="350" width="500"></canvas> -->
						</div>
					</div>
					
					<div class="w3-container">
						<div class="w3-panel w3-gray">
							<p>일자별 차트</p>
						</div>
						<div style="height:700px; width:800px">
							<canvas id="canvas"></canvas>
							<!-- <canvas id="canvas" height="350" width="500"></canvas> -->
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
	 
	<script>
		var chartLabels = [];
		var chartData1 = [];
		var chartData2 = [];
		
		
		$.getJSON("http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/board/allListData", function(data){
			$.each(data, function(inx, obj){
				chartLabels.push(obj.imgName);
				chartData1.push(obj.uncut);
				chartData2.push(obj.spalling);
				});
			createChart();
		})
		

		var lineChartData = {
			labels : chartLabels,
			datasets : [{
				label : "미절삭 섬유",
				type : 'line',
				backgroundColor: "#bfdaf9",
				borderColor: "#80b6f4",
				pointBorderColor: "#80b6f4",
				pointBackgroundColor: "#80b6f4",
				pointHoverBackgroundColor: "#80b6f4",
				pointHoverBorderColor: "#80b6f4",
				fill: false,
				borderWidth: 3,
				data : chartData1
			},{
				label : "박리현상",
				type : 'line',
				backgroundColor: "#4e4e4e",
				borderColor: "#4e4e4e",
				pointBorderColor: "#4e4e4e",
				pointBackgroundColor: "#4e4e4e",
				pointHoverBackgroundColor: "#4e4e4e",
				pointHoverBorderColor: "#4e4e4e",
				fill: false,
				borderWidth: 3,
				data : chartData2
			}]
		
		}
		function createChart(){
			var ctx = document.getElementById("canvas").getContext("2d");
				LineChartDemo = Chart.Line(ctx,{
					data : lineChartData,
					options : {
						scales : {
							yAxes : [{
								ticks : {
									beginAtZero : true
								}
							}]
						}
					}
			});
		
		}
	</script>

	
	<br><br><hr color="black"/>
</body>
</html>

<jsp:include page="/WEB-INF/views/sideView/footer.jsp"></jsp:include>