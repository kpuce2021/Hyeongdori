<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>



<html>
	<style>
	.inputArea { margin:10px 0; }
	label { display:inline-block; width:70px; padding:5px; }
	.select_img img { margin:20px 0; }
	
	
	</style>
	
	<head>
	<meta charset="UTF-8">
	<title>이미지 선택</title>
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
		         	<h2><i class="glyphicon glyphicon-upload"></i>검출 전 이미지 선택</h2>
		            <hr><br>
		            <div class="alert alert-danger" role="alert">
		            	<i class="glyphicon glyphicon-alert"></i>
						CFRP 관련 이미지만 선택하세요
					</div>
					<div class="alert alert-danger" role="alert">
						<i class="glyphicon glyphicon-alert"></i>
						가공 결함 검출 전 이미지만 선택하세요
					</div>
		            <br>
		            <!-- 웹에서 서버로 로컬에 검출 전 이미지를 보내는 부분 -->  
		            	
		            		<form class="form-inline" action="webToServer" enctype="multipart/form-data" method="post" >
								<fieldset>
									<legend>로컬에서 파일 선택</legend>
									<div class="form-group" >
										<input type="file" name="uploadfile" id="uploadImage"/>
									</div>
									
									<input class="btn btn-primary" type="submit" value="서버로 전송"/>
								</fieldset>
							</form>
					
							<br>
							<br>
							
		             <!-- 넣고싶은 글 넣으면 됌  -->
		         </div>
		      </div>
		</div>
		
		<hr color="black">
		
		
	</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
