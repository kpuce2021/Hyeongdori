<!-- registerUser -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<style>
.note
{
    text-align: center;
    height: 80px;
    background: -webkit-linear-gradient(left, #0072ff, #8811c5);
    color: #fff;
    font-weight: bold;
    line-height: 80px;
}
.form-content
{
    padding: 5%;
    border: 1px solid #ced4da;
    margin-bottom: 2%;
}
.form-control{
    border-radius:1.5rem;
}
.btnSubmit
{
    border:none;
    border-radius:1.5rem;
    padding: 1%;
    width: 20%;
    cursor: pointer;
    background: #0062cc;
    color: #fff;
}
.register-form{
	position:absolute;
	top:15%;
	left:20%;
	width:100px;
	height:100px;
	margin:-50px 0 0 -50px;
}
</style>
<head>
	<meta charset="UTF-8">
	<title>Register page</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<script type="text/javascript">
			$(document).ready(function(){
				$(".cancle").on("click", function(){
					location.href = "http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/main/home";
				})
				$("#submit").on("click", function(){
					if($("#id").val() == ""){
						alert("아이디를 입력해주세요.");
						$("#id").focus();
						return false;
					}
					if($("#passwd").val() == ""){
						alert("비밀번호를 입력해주세요.");
						$("#passwd").focus();
						return false;
					}
					if($("#email").val() == ""){
						alert("이메일을 입력해주세요.");
						$("#email").focus();
						return false;
					}
					if($("#mobile").val() == ""){
						alert("핸드폰 번호를 입력해주세요.");
						$("#mobile").focus();
						return false;
					}
					var idChkVal = $("#idChk").val();
					if(idChkVal == "N"){
						alert("중복확인 버튼을 눌러주세요");
					}else if(idChkVal == "Y"){
						$("#regForm").submit();
					}
				});
				
			})
			function fn_idChk(){
				$.ajax({
					url : "http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/idChk",
					type : "post",
					dataType : "json",
					data : {"id" : $("#id").val()},
					success : function(data){
						if(data == 1){
							alert("중복된 아이디입니다.");
						}else if(data == 0){
							$("#idChk").attr("value", "Y");
							alert("사용가능한 아이디입니다.");
						}
					}
				})
			}
	</script>
</head>


<body>
	<div class="container-fluid">
		<div class="container register-form">
            <div class="form">
                <div class="note">
                    <p>회원가입</p>
                </div>

			<form action="/main-1.0.0-BUILD-SNAPSHOT/registProcess" method="post" id="regForm">
                <div class="form-content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                            	
                                <input type="text" id="id" class="form-control" placeholder="Your Id *" name="id"/>
                                <button style="float:left; margin-top:5px; margin-bottom:10px" class="idChk btn btn-primary" type="button" id="idChk" onClick="fn_idChk();" value="N">아이디 중복확인</button>
                            	
                            </div>
                            <div class="form-group">
                                <input type="text" id="passwd" class="form-control" placeholder="Your Password *" name="passwd"/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="email" class="form-control" placeholder="Email *" name="email"/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="mobile" class="form-control" placeholder="Mobile *" name="mobile"/>
                            </div>
                        </div>
                        
                    </div>
                    <button type="submit" class="btnSubmit" id="submit">Submit</button>
                    <button type="button" class="cancle btnSubmit">Cancle</button>
                </div>
             </form>
             
            </div>
        </div>
	</div>
</body>
</html>