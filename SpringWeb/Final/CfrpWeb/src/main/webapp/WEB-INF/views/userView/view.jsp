<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

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
		            <!-- side menu (link) -->
		            <jsp:include page="/WEB-INF/views/sideView/sideBar.jsp"></jsp:include>
		         </div>
		         <!-- right content -->
		         <div class="col-sm-8">
		         <jsp:include page="/WEB-INF/views/sideView/header.jsp"></jsp:include>
		         <br>
		         	<h2><i class="glyphicon glyphicon-transfer"></i>전송 결과 확인 
		         	<button class="btn btn-primary" onclick="location.href='http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/main/home'">홈으로 이동</button>
		         	<button class="btn btn-primary" onclick="location.href='http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/formFile'">다른 이미지 선택</button>
		         	<button class="btn btn-primary" onclick="location.href='http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/board/myDetectList?img=#'">내 결과 리스트</button>
		         	</h2>
		         		<div class="row">
			         		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="false">
			         			<div class="panel panel-default">
			         				<div class="panel-heading" role="tab" id="headingOne">
			         					<h4 class="panel-title">
			         						<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true">
			         						${result.getResult()}개의 결함 발견	
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
			         		<br>
			         		<table>
			         			<tr><th>현재 사용자 : </th><td><label type="text">${ResultVO.id}</label></td></tr>
			         			<tr><th>저장된 이미지 : </th><td><label type="text">${ResultVO.imgName}</label></td></tr>
			         			<tr><th>발견된 uncut(미절삭 섬유) 개수 : </th><td><label type="text">${ResultVO.uncut}</label></td></tr>
			         			<tr><th>발견된 spalling(박리현상) 개수 : </th><td><label type="text">${ResultVO.spalling}</label></td></tr>
			         		</table>
			         		
			         	  </div>
			         	  <br><hr color="black">
			         	  <jsp:include page="/WEB-INF/views/sideView/footer.jsp"></jsp:include>
			         	</div>
		         	</div>
		         </div>	         
	
</body>

</html>