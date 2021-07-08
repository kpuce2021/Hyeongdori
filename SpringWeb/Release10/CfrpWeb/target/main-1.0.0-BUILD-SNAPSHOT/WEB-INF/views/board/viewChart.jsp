<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/sideView/header.jsp"></jsp:include>

<html xmlns:th="http://www.thymeleaf.org">

<head>
	<meta charset="UTF-8">
	<title>detect Chart</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 	
</head>

<body>
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
		            <jsp:include page="/WEB-INF/views/sideView/sideBar.jsp"></jsp:include>
		         </div>
		         <!-- right content -->
		         <div class="col-sm-8">
		         <br>
		         	<h2><i class="glyphicon glyphicon-th-list"></i>검출 결과 차트</h2>
		            <hr><br>
		            <!-- side menu (link) -->
		            <canvas id="logChart" width="400" height="400"></canvas>
				 </div>
		</div>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
		
		<script>
			var ctx = document.getElementById("logChart").getContext('2d');
			var myChart = new Chart(ctx,{

				type: 'bar',
				data: {

					labels: ["uncut", "spalling"],
					datasets: [{

						data: ['${uncut}', '${spalling}'],
						backgroundColor: [

							'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)'
							],
							borderColor:[

								'rgba(255, 99, 132, 1)',
								'rgba(54, 162, 235, 1)'
								],
								borderWidth: 1
						}]
					},
					options: {

						scales: {

							yAxes: [{

								ticks:{

									beginAtZero:true
									}
								}]
							}
						}
				});
		</script>
	<br>
	            
	</div>
	<hr color="black">      
</body>
</html>

<jsp:include page="/WEB-INF/views/sideView/footer.jsp"></jsp:include>