<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

HI
<img alt="" src="/getByteImages"/>
<c:forEach items="${image}" var="result" varStatus="status">
	<tr><td><img src="${result.img}"/></td></tr>
</c:forEach>

</body>
</html>