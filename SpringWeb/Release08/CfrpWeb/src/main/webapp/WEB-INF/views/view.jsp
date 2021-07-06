<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<head>
	<meta charset="UTF-8">
	<title>전송 받은 이미지 확인</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
		            <jsp:include page="/WEB-INF/views/sideBar.jsp"></jsp:include>
		         </div>
		         <!-- right content -->
		         <div class="col-sm-8">
		         <br>
		         	<h2><i class="glyphicon glyphicon-transfer"></i>전송 결과 확인 
		         	<button class="btn btn-default" href="/main-1.0.0-BUILD-SNAPSHOT/main/home">홈으로 이동</button>
		         	<button class="btn btn-default" href="/main-1.0.0-BUILD-SNAPSHOT/formFile">다른 이미지 선택</button>
		         	</h2>
		         		<div class="row">
			         		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="false">
			         			<div class="panel panel-default">
			         				<div class="panel-heading" role="tab" id="headingOne">
			         					<h4 class="panel-title">
			         						<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true">
			         						${result.getResult()} Click[이미지 확인]	
			         						</a>
			         					</h4>
			         				</div>
			         				<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
			         					<div class="panel-body">
			         						<img src="${result.getUrl()}" alt="Not Found Image" width="720" height="550">
			         					</div>
			         					
			         				</div>
			         			</div>
			         		</div>
			         	  </div>
			         	</div>
		         	</div>
		         </div>	         
	<br>
	<hr>
</body>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>