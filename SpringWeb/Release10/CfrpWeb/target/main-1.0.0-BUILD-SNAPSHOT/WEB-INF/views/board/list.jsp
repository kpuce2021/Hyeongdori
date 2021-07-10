<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:th="http://www.thymeleaf.org">

<jsp:include page="/WEB-INF/views/sideView/header.jsp"></jsp:include>

<head>
	<meta charset="UTF-8">
	<title>detect Chart</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body> 
	<hr color="black"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
	
	<!-- style="width: 80%"  -->
	<div align="center">
		<div>
			<canvas id="canvas" height="450" width="600"></canvas>
		</div>
	</div>
	
	<script>
		var chartLabels = [];
		var chartData1 = [];
		var chartData2 = [];
		
		
		$.getJSON("http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/board/listData", function(data){
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
				fillColor : "rgba(114, 66, 47, 0.7)",
				strokeColor : "rgba(114, 66, 47, 0.7)",
				pointColor : "rgba(114, 66, 47, 0.7)",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(114, 66, 47, 0.7)",
				data : chartData1
			},{
				label : "박리현상",
				type : 'line',
				fillColor : "rgba(151,187, 205, 1)",
				strokeColor : "rgba(151, 187, 205, 1)",
				pointColor : "rgba(151, 187, 205, 1)",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(151, 187, 205, 1)",
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