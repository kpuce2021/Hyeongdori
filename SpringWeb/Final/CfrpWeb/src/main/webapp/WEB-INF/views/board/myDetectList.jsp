<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html>
	<head>
	<meta charset="UTF-8">
	<title>나의 검출 후 이미지 리스트</title>
	
	<link rel="stylesheet" href="${path}/resources/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${path}/resources/css/owl.theme.default.min.css">
	<link rel="stylesheet" href="${path}/resources/css/owl.theme.default.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>
	<body>
		<!-- content -->
		<!-- container-fluid로 좌우로 꽉 찬 레이아웃을 만든다. -->
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
		         	
		         	<h2><i class="glyphicon glyphicon-th-list"></i> 내 검출 결과 리스트</h2>
		            <hr><br>
		            <!-- side menu (link) -->  
		             <div id="wrapper">
				        <div class="owl-carousel owl-theme">
				        	<c:forEach var="file" items="${resultList}" varStatus="status">
				        		<div class="item">
				   					<c:out value="${file}"/>
				   					<a href="http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/board/myDetectList?img=${file}">
				                	<img src="http://3.34.77.179:8080/detect/${file}"/></a><br>
				            
				            	</div>
				        	</c:forEach>
				        </div>
				    </div>
		            	
		            <br><br>
		            
		            <p style="color:red; font-style:italic">위에 사진을 클릭하면 확대해서 볼 수 있습니다.</p><br>
		            <button onclick="myFunction('Demo1')" class="w3-btn w3-round-large w3-block w3-left-align" style="background-color:#EBEDEF"><i class="glyphicon glyphicon-zoom-in"></i>검출 후 이미지 : ${img}</button>
					<div id="Demo1" class="w3-container w3-hide">
					  <img src="http://3.34.77.179:8080/detect/${img}" width="700" height="500" alt="no image"/>
					</div>
					<br>
					<button onclick="myFunction('Demo2')" class="w3-btn w3-round-large w3-block w3-left-align" style="background-color:#EBEDEF"><i class="glyphicon glyphicon-zoom-in"></i>검출 전 이미지 : ${img}</button>
					<div id="Demo2" class="w3-container w3-hide">
					  <img src="http://3.34.77.179:8080/upload/${img}" width="700" height="500" alt="no image"/>
					</div>
					
					<script type="text/javascript" src="<c:url value="/resources/js/accordions.js"/>"></script>
					
					<br><hr color="black"/>
		            <jsp:include page="/WEB-INF/views/sideView/footer.jsp"></jsp:include>
		         </div>
		      </div>
		 </div>

			<script src="http://code.jquery.com/jquery-latest.js"></script>
			<script src="${path}/resources/js/owl.carousel.min.js"></script>
			<script src="${path}/resources/js/owl.autoplay.js"></script>
			<script src="${path}/resources/js/owl.navigation.js"></script>
			
			<script>
		        $(function () {
		            $('.owl-carousel').owlCarousel({
		                items: 3,
		                margin: 10,
		                loop: true,
		                nav: true,
		                navText: ['이전', '다음'],
		                autoplay: true,
		                autoplayTimeout: 3000,
		                autoplayHoverPause: true
		            });
		        });
		    </script>
	</body>
</html>

