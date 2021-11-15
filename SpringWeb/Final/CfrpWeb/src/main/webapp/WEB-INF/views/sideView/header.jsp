<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<style>
			ul{
				list-style:none;
				padding-left:0px;
			}
		</style>
	</head>
	
	<body>
		
		<nav class="navbar navbar-expand-lg">
			<ul>
				<li>
					 <a class="navbar-brand" href="/main-1.0.0-BUILD-SNAPSHOT/main/home">
					 <i class="glyphicon glyphicon-home"></i> CFRP Web Page</a>
				 </li>
				 
				 <li>
				 
					  <div class="collapse navbar-collapse navbar-right" id="navbarsExample05">
					  	<!-- Session이 없을 때 로그인 form 제공 -->
					  	<c:if test="${login == null}">
						  	<form class="form-inline" action="/main-1.0.0-BUILD-SNAPSHOT/loginProcess" method="post" style="margin-top:10px; margin-right:15px">
						    	<div class="form-group">
						    		<input type="text" name="id" class="form-control mr-2" placeholder="id">
						    	</div>
						    	<div class="form-group">
						    		<input type="password" name="passwd" class="form-control mr-2" placeholder="password">
						    	</div>
						    	<button type="submit" class="btn btn-primary">Sign in</button>
						    	<button type="button" onclick="location.href='http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/registPage'" class="btn btn-primary">
						    		Sign up
						    	</button>
						    </form>
						</c:if>
						
						<!-- Session 존재시 사용자 form 제공 -->
						<c:if test="${login != null}">
						<div class="w3-container" style="margin-top:10px; margin-right:15px">
							<label style="margin-right:5px" class="w3-text-black">${login.id}님 환영합니다. </label>
							<button type="button" style="margin-right:5px" onclick="location.href='http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/myInfo'" class="btn btn-primary">
								내 정보
							</button>
							<button type="button" onclick="location.href='http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/logoutProcess'" class="btn btn-primary">
								로그아웃
							</button>
						</div>
						</c:if>
					  </div>
				
				
				  </li>
			  </ul>
		</nav>
	</body>
	<hr style="height:1px;border-width:0;color:gray;background-color:gray"><br>
</html>
