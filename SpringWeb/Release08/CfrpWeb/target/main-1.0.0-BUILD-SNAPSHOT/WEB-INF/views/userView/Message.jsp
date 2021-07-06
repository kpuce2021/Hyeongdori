<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<th:block th:if="${#strings.length(data.message) != 0}">
		<script>
			top.alert("[[${data.message}]]");
		</script>
	</th:block>
	<th:block th:if="${#strings.length(data.href) != 0}">
		<script>
			top.location.href='[[${data.href}]]';
		</script>
	</th:block>
</head>
<body>

</body>
</html>