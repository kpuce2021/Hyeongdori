<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/solid.js" integrity="sha384-+Ga2s7YBbhOD6nie0DzrZpJes+b2K1xkpKxTFFcx59QmVPaSA8c7pycsNaFwUK6l" crossorigin="anonymous"></script>
		<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/fontawesome.js" integrity="sha384-7ox8Q2yzO/uWircfojVuCQOZl+ZZBg2D2J5nkpLqzH1HY0C1dHlTKIbpRz/LG23c" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="jumbotron well">
			<div class="text-center">
				<h1>KPU 졸업작품</h1>
			  	<p>한국 산업 기술대학교 컴퓨터공학부 졸업작품<br> 딥 러닝을 적용한 CFRP 가공 결함 검출 웹페이지 입니다.</p>
			  	<br>
			  	<p>
			  		<a class="btn btn-primary btn-lg" href="https://github.com/kpuce2021/Hyeongdori" role="button">
			  			<i class="fab fa-github-square" aria-hidden="true"></i>Our Github</a>
			  	</p>
			</div>
		</div>
		
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
		            <h2 class="front-italic">'딥러닝을 적용한 CFRP 가공 결함 검출'</h2>
		            <p class="front-italic">2020-01-10 ~ 2021-08-10</p>
		            <hr>
		            <!-- side menu (link) -->  
		            	<jsp:include page="/WEB-INF/views/thumbnail.jsp"></jsp:include>
		             <!-- 넣고싶은 글 넣으면 됌  -->
		         </div>
		      </div>
		   </div>
		
		<hr color="black">
	</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
