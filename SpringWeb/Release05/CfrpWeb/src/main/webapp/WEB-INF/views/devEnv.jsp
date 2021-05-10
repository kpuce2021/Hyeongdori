<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<html>
	<head>
	<meta charset="UTF-8">
	<title>개발 환경</title>
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
		            <br>
		            <h2 class="front-italic">개발 환경</h2>
		            <p class="front-italic">2020-01-10 ~ 2021-08-10</p>
		            <hr>
					<div data-role=content>
					    <ol id=list1 data-role=listview data-inset=true>				
					      <li data-role=list-divider>개발 환경 리스트</li>		
					      <li data-icon=info>		
					        <a href=#>STS 4</a>			
					      </li>			
					      <li data-icon=info>	
					        <a href=#>Android Studio</a>
					      </li>			
					      <li data-icon=info>			
					        <a href=#>AWS EC2 Ubuntu Server</a>		
					      </li>	
					    </ol>
					  </div>
					
					</div>



		         </div>
		      </div>
		</div>
		
		<hr color="black">
		
		
	</body>
</html>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
