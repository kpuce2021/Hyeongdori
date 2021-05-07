<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" href="${path}/resources/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${path}/resources/css/owl.theme.default.min.css">
	<link rel="stylesheet" href="${path}/resources/css/owl.theme.default.css">
	
	</head>
	<body>
		<!-- content -->
		<!-- container-fluid로 좌우로 꽉 찬 레이아웃을 만든다. -->
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
		            <hr>
		            <!-- side menu (link) -->  
		             <div id="wrapper">
				        <div class="owl-carousel owl-theme">
				        	<c:forEach var="file" items="${fileList}">
				        		<div class="item">
				   
				                	<img src="http://3.34.46.163:8080/upload/${file}"/><br>
				            
				            	</div>
				        	</c:forEach>
				        	
				            <!-- 
				            <div class="item">
				                <img src="resources/img/001.png">
				            </div>
				            <div class="item">
				                <img src="resources/img/002.jpg">
				            </div>
				            <div class="item">
				                <img src="resources/img/003.jpg">
				            </div>
				            <div class="item">
				                <img src="resources/img/004.jpg">
				            </div>
				            <div class="item">
				                <img src="resources/img/002.jpg">
				            </div>
				            <div class="item">
				                <img src="resources/img/001.png">
				            </div>
				             -->
				        </div>
				    </div>
		            	
		            
		            	
		             <!-- 넣고싶은 글 넣으면 됌  -->
		         </div>
		      </div>
		 </div>
		
		<hr color="black">
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


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
