<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


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
		         <br>
		         	<h2><i class="glyphicon glyphicon-th-list"></i>업로드 된 이미지 확인</h2>
		            <hr><br>
		             
		             <div id="wrapper">
				        <div class="owl-carousel owl-theme">
				        	<c:forEach var="file" items="${fileList}" varStatus="status">
				        		<div class="item">
				   					<c:out value="${file}"/>
				   					<a href="http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/selectImage?img=${file}">
				                	<img src="http://3.37.42.228:8080/upload/${file}"/></a><br>  
				                	
				            	</div>
				        	</c:forEach>
				        </div>
				    </div>
				    <br>
				    <c:if test="${img != null}">
					    <fieldset>
					    	<legend><h4><i class="glyphicon glyphicon-zoom-in"></i>${img} 자세히 보기</h4></legend>
			            	<img src="http://3.37.42.228:8080/upload/${img}" width="720" height="500" alt="no image"/>
			            </fieldset>
		            </c:if>
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
