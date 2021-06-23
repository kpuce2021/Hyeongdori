<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>detect 리스트</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body>
	<h2>게시판 리스트</h2>
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
		         	<h2><i class="glyphicon glyphicon-th-list"></i>검출 후 이미지 확인</h2>
		            <hr><br>
		            <!-- side menu (link) -->  
				        	<c:forEach var="file" items="${fileNameList}" varStatus="status">
				        		<div class="item">
				   					<c:out value="${file}"/>
				            	</div>
				        	</c:forEach>
				        	<br><br>
				        	<c:forEach var="result" items="${resultList}" varStatus="status">
				        		<div class="item">
				   					<c:out value="${result}"/>
				            	</div>
				        	</c:forEach>
				        </div>
				    </div>
		            	
		            <br>
		            
		         </div>
		      
</body>
</html>