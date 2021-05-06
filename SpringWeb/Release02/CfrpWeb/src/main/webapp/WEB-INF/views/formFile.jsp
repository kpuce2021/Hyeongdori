<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<html>
	<head>
	<meta charset="UTF-8">
	<title>file upload form</title>
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
		            <hr>
		            
		            <!-- side menu (link) -->  
		            	<form class="form-inline" action="/saveImage" enctype="multipart/form-data" method="post" >
							<div class="form-grouop" >
							
								<input type="file" class="form-control" name="img" id="filename"/>
							</div>
							
							
							<input type="submit" value="서버전송"/>
						</form>
						<br>
						<form class="form-inline" action="/receive/FileToAndroid" enctype="multipart/form-data" method="post" >
							<div class="form-grouop" >
							
								<input type="file" class="form-control" name="img" id="filename"/>
							</div>
							
							
							<input type="submit" value="서버전송"/>
						</form>
		             <!-- 넣고싶은 글 넣으면 됌  -->
		         </div>
		      </div>
		</div>
		
		<hr color="black">
		
	</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
