<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html>
	<head>
	<meta charset="UTF-8">
	<title>검출 전 이미지</title>
	
	<link rel="stylesheet" href="${path}/resources/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${path}/resources/css/owl.theme.default.min.css">
	<link rel="stylesheet" href="${path}/resources/css/owl.theme.default.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2021.css">
	
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

		         	<h2><i class="glyphicon glyphicon-th-list"></i>업로드 된 이미지 확인</h2>
		            <hr><br>
		             
		             <div id="wrapper">
				        <div class="owl-carousel owl-theme">
				        	<c:forEach var="file" items="${fileList}" varStatus="status">
				        		<div class="item">
				   					<c:out value="${file}"/>
				   					<a href="http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/selectImage?img=${file}">
				                	<img src="http://3.34.77.179:8080/upload/${file}"/></a><br>  
				                	
				            	</div>
				        	</c:forEach>
				        </div>
				    </div>
				    <br>
				    
				    <p style="color:red; font-style:italic">위에 사진을 클릭하면 확대해서 볼 수 있습니다.</p><br>
				    
				    <c:if test="${img != null}">
				    <button onclick="myFunction('Demo1')" class="w3-btn w3-round-large w3-block w3-left-align" style="background-color:#EBEDEF"><i class="glyphicon glyphicon-zoom-in"></i> ${img} 자세히 보기</button>
					<div id="Demo1" class="w3-container w3-hide">
					  <img src="http://3.34.77.179:8080/upload/${img}" width="720" height="500" alt="no image"/>
					</div>
					<script type="text/javascript" src="<c:url value="/resources/js/accordions.js"/>"></script>
				    <!-- 
					    <fieldset>
					    	<legend><h4><i class="glyphicon glyphicon-zoom-in"></i>${img} 자세히 보기</h4></legend>
			            	<img src="http://3.34.77.179:8080/upload/${img}" width="720" height="500" alt="no image"/>
			            </fieldset>
					-->
		            </c:if>
		             <!-- 넣고싶은 글 넣으면 됌  -->
		             <br><hr color="black">
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
		                loop: false,
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
