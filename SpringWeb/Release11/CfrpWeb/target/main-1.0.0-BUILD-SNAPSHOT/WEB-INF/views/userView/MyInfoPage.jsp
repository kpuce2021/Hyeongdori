<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/sideView/header.jsp"></jsp:include>

<html>
<head>
	<meta charset="UTF-8">
	<title>내 정보</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
			<hr color="black"><br>
			<div class="container-fluid">
		      <div class="row">
		         <!-- left content -->
		         <div class="col-sm-3">
		            <!-- side menu (link) -->
		            <jsp:include page="/WEB-INF/views/sideView/myInfoSideBar.jsp"></jsp:include>
		         </div>
		         
		         <!-- right content -->
		         <div class="col-sm-8">
		         <br>
		         	<h2><i class="glyphicon glyphicon-user"></i>내 정보</h2>
		            <hr><br>
		            <table class="table">
					  <thead>
					    <tr>
					      <th scope="col">사용자 ID</th>
					      <th scope="col">사용자 PASSWORD</th>
					      <th scope="col">Email</th>
					      <th scope="col">Mobile</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row">${user.id}</th>
					      <td>${user.passwd}</td>
					      <td>${user.email}</td>
					      <td>${user.mobile}</td>
					    </tr>
					    
					  </tbody>
					</table>
					<br><br>
					<h2><i class="glyphicon glyphicon-user"></i>내 히스토리</h2>
		            <hr><br>
		            <table class="table">
					  <thead>
					    <tr>
					      <th scope="col">이미지</th>
					      <th scope="col">uncut(미절삭 섬유) 개수</th>
					      <th scope="col">spalling(박리현상) 개수</th>
					      
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach var="resultList" items="${resultList}">
						    <tr>
						      <th scope="row">${resultList.imgName}</th>
						      <td>${resultList.uncut}</td>
						      <td>${resultList.spalling}</td>
						    </tr>
					    </c:forEach>
					  </tbody>
					</table>
		         </div>
		      </div>
		</div>
		<br>
		<hr color="black">
		
</body>
</html>

<jsp:include page="/WEB-INF/views/sideView/footer.jsp"></jsp:include>