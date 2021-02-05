<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>CFRP :: Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="css/login.css">
   <link rel="icon" href="image/favicon.png">
</head>
<body>
   <!-- header -->
   <div class="jumbotron text-center mb-0">
      <h1>CFRP</h1>
      <p>CFRP 가공 결함 검출 페이지</p>
   </div>
   <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <!-- 리스트 : 부트스트랩은 모바일 우선이라 화면이 작으면 아래로 쌓아서 내려온다 -->
      <ul class="navbar-nav navbar-dark">
         <li class="nav-item active"><a class="nav-link" href="main.jsp">HOME</a></li>
      </ul>
      <!-- Search -->
      <form class="form-inline ml-auto" action="">
      
         <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav navbar-dark">
	      		 <li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
	        	 <li class="nav-item"><a class="nav-link" href="#">CFRP 소개</a></li>
	        	 <li class="nav-item dropdown">
	            	<!-- 드롭다운 메뉴-->
			          <a class="nav-link dropdown-toggle" href="#"
			            data-toggle="dropdown"> 관련 기술 </a>
			            
			            <div class="dropdown-menu">
			               <a class="dropdown-item" href="#">이미지 전처리</a> 
			               <a class="dropdown-item" href="#">딥 러닝</a> 
			               <a class="dropdown-item" href="#">웹 페이지 개발</a>
	           			</div>
	         	</li>
        	</ul>
         </nav>
         
         <!-- inline여야 간격이 없이 메뉴처럼 나온다. ml-atuo : 우측으로 붙게하기-->
         <input class="form-control mr-sm-2" type="text" placeholder="Search">
         <!-- form-control 입력창 꾸며주는 클래스 -->
         <button class="btn btn-success" type="submit">Search</button>
      </form>
   </nav>
  
         
   		
         
          <!-- content -->
   <div class="container pt-3">
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
             <hr>
             <!-- <%@include file="Logout_sidebar.jsp" %> -->
             
         <%@include file="Login_sidebar.jsp" %>
           
             <hr>
            <!-- side menu (link) -->
            <%@include file="sidebar.jsp" %>
         </div>
         <!-- right content -->
         <div class="col-sm-8">
            <h2>공정 처리 과정</h2>
            <hr>
           
           	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
           	
           	<ui class="list-group">
           		<li class="list-group-item">
				    <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingOne">
				      <h5 class="panel-title">
				        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				          CFRP 가공 공정 #1
				        </a>
				      </h5>
				    </div>
				    
				    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
				      <div class="panel-body">
				        <img src="https://user-images.githubusercontent.com/55940552/106982607-c0655d80-67a7-11eb-97b5-67246cb3bfdf.png" width="550" height="200">
				        <br>
				      </div>
				    </div>
				  </div>
				</li>
			  
			  <li class="list-group-item">
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingTwo">
				      <h5 class="panel-title">
				        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				           가공 이미지 촬영 #2
				        </a>
				      </h5>
				    </div>
				    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
				      <div class="panel-body">
				        <img src="https://user-images.githubusercontent.com/55940552/106983966-189d5f00-67aa-11eb-9e1d-4d15b84fe128.png" width="550" height="300">
				      </div>
				    </div>
				  </div>
				</li>
				
				<li class="list-group-item">
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingThree">
					      <h5 class="panel-title">
					        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
					          서버로 이미지 전송 #3
					        </a>
					      </h5>
					    </div>
					    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
					      <div class="panel-body">
					         <img src="https://user-images.githubusercontent.com/55940552/106984310-a9743a80-67aa-11eb-8484-1efc44ebac27.png" width="580" height="290">
					      </div>
					    </div>
					  </div>
				</li>
				
				<li class="list-group-item">
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingFour">
					      <h5 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
					          학습된 딥러닝을 통한 결함 검출 #4
					        </a>
					      </h5>
					    </div>
					    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
					      <div class="panel-body">
					        <img src="https://user-images.githubusercontent.com/55940552/106985422-c7db3580-67ac-11eb-8eac-b07be7e55cdb.png" width="585" height="250">
					      </div>
					    </div>
					  </div>
					  
					</li>
					
				<li class="list-group-item">
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingFive">
						      <h5 class="panel-title">
						        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
						          웹 페이지로 검출 결과 전송 #5
						        </a>
						      </h5>
						    </div>
						    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
						      <div class="panel-body">
						        <img src="https://user-images.githubusercontent.com/55940552/106985891-9adb5280-67ad-11eb-87ea-bb33ca5fbb1e.png" width="580" height="290">
						      </div>
						    </div>
						  </div>
						  
						  </li>
						  
				<li class="list-group-item">
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingSix">
				      <h5 class="panel-title">
				        <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="true" aria-controls="collapseSix">
				         사용자, 검출 결과 확인 #6
				        </a>
				      </h5>
				    </div>
				    <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
				      <div class="panel-body">
				        <img src="https://user-images.githubusercontent.com/55940552/106986599-08d44980-67af-11eb-8590-f452e78a2d3e.png" width="580" height="250">
				      </div>
				    </div>
				  </div>
				 </li>
			  </ui>
			</div>
            
            
            <div class="text-center">
            </div>
             <!-- 넣고싶은 글 넣으면 됌  -->
         </div>
      </div>
      <hr>
   </div>
   <!-- footer -->
   <jsp:include page="footer.jsp" />

</body>
</html>