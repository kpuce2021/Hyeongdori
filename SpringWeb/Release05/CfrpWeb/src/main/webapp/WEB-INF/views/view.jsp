<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검출 전 이미지 전송</title>
</head>
<body>

	<p>${result.getResult()}</p>
	<br>
	<img src="${result.getUrl()}" height="480" width="450"/>
	
	<br>
	<div class="list-group">
		<a href="/main-1.0.0-BUILD-SNAPSHOT/main/home" class="list-group-item">Home으로 이동</a>
		<a href="/main-1.0.0-BUILD-SNAPSHOT/formFile" class="list-group-item">다른 이미지 전송</a>
	</div>
</body>
</html>