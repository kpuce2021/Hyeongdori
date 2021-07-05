<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:th="http://www.thymeleaf.org">

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<head>
	<meta charset="UTF-8">
	<title>detect 리스트</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 	


</head>

<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
	
	<div class="container-fluid">
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
		            <jsp:include page="/WEB-INF/views/sideBar.jsp"></jsp:include>
		         </div>
		         <!-- right content -->
		         <div class="col-sm-8">
		         <br>
		         	<h2><i class="glyphicon glyphicon-th-list"></i>검출 결과 목록</h2>
		            <hr><br>
		            <!-- side menu (link) -->
		            <div style="width:60%">
		            	<div>
		            		<canvas id="canvas" height="450" width="600"></canvas>
		            	</div>
		            </div>
		            <!-- 
				        	<c:forEach var="file" items="${fileNameList}" varStatus="status">
				        		<div class="item">
				   					<c:out value="${file}"/>
				            	</div>
				        	</c:forEach>
				        	<br><br>
				        	<c:forEach var="result" items="${resultList}" varStatus="status">
				        		<div class="item">
				   					<c:out value="${result}"/>
				            	</div>
				        	</c:forEach>
				     -->
				 </div>
		</div>
		            	
	<br>
		            
</div>
<script>
	var charLabels = [];
	var charData = [];

	$.getJson("http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/list", function(data){

		$.each(data, function(inx, obj)){

			charLabels.push(obj.result);
			charData.push(obj.count);
			});
			createChart();
			console.log("create chart");
		});

	var lineChartData={

			labels : charLabels,
			datasets : [
					{
						label : "data income",
						fillColor : "rbga(151, 187, 205, 0.2)",
						strokeColor : "rbga(151, 187, 205, 1)",
						pointColor : "rbga(151, 187, 205, 1)",
						pointStrokeColor : "#fff",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rbga(151, 187, 205, 1)",
						data : charData
						}
				]
			}

	function createChart(){

		var ctx = document.getElementById("canvas").getContext("2d");

		LineCharDemo = Chart.Line(ctx, {

			data : lineChartData,
			options :{
					scales : {
							yAxes : [{
								ticks :{
										beginAtZero : true
									}
								}]
						}
				}
			})
		}
</script>
		      
</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>