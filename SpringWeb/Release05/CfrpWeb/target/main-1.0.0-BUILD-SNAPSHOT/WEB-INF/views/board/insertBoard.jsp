<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/solid.js" integrity="sha384-+Ga2s7YBbhOD6nie0DzrZpJes+b2K1xkpKxTFFcx59QmVPaSA8c7pycsNaFwUK6l" crossorigin="anonymous"></script>
		<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/fontawesome.js" integrity="sha384-7ox8Q2yzO/uWircfojVuCQOZl+ZZBg2D2J5nkpLqzH1HY0C1dHlTKIbpRz/LG23c" crossorigin="anonymous"></script>
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
		            <h2 class="front-italic">'딥러닝을 적용한 CFRP 가공 결함 검출'</h2>
		            <p class="front-italic">2020-01-10 ~ 2021-08-10</p>
		            <hr>
		            <!-- side menu (link) -->  
		            <h1>글 쓰기</h1>
					<hr>
					<form action="insertBoard" method="post" enctype="multipart/form-data">
						<table border="1">
							<tr>
								<td bgcolor="orange" width="70">제목</td>
								<td align="left"><input type="text" name="title" /></td>
							</tr>
							<tr>
								<td bgcolor="orange">작성자</td>
								<td align="left"><input type="text" name="writer" size="10" /></td>
							</tr>
							<tr>
								<td bgcolor="orange">내용</td>
								<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
							</tr>
							<tr>
								<td bgcolor="orange" width="70">업로드</td><td align="left">
								<input type="file" name="uploadFile"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit" value="글 쓰기" /></td>
							</tr>
						</table>
					</form>
					<hr>
		            <!-- 넣고싶은 글 넣으면 됌  -->
		         </div>
		      </div>
		   </div>
		
		<hr color="black">
	</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>