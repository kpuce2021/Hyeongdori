<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
						  	<form class="form-inline" method="post">
						    	<div class="form-group">
						    		<input type="text" name="id" class="form-control mr-2" placeholder="id">
						    	</div>
						    	<div class="form-group">
						    		<input type="text" name="passwd" class="form-control mr-2" placeholder="password">
						    	</div>
						    	<button type="submit" class="btn btn-primary">Sign in</button>
						    	<button type="button" onclick="location.href='http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/registerProcessing'" class="btn btn-primary">
						    		Sign up
						    </button>
						    </form>
						    
					  </div>
				  </li>
			  </ul>
		</nav>
	
		<hr>
	</body>

</html>
