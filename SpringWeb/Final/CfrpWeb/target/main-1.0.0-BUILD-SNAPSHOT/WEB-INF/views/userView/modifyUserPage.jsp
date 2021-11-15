<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>내 정보 수정 페이지</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
 	<div class="container-fluid">
		<div class="container register-form">
            <div class="form">
                <div class="note">
                    <p>내 정보 수정</p>
                </div>

			<form action="/main-1.0.0-BUILD-SNAPSHOT/modifyUser" method="post">
                <div class="form-content">
                    <div class="row">
                        <div class="col-md-6">
                        	<div align="center">
	                            <div class="form-group">
	                            	<label class="w3-text-blue" align="left"><b>User ID</b></label>
	                                <input type="text" id="id" class="form-control" name="id" readonly value="${user.id}"/>
	                            </div>
	                            <div class="form-group">
	                            	<label class="w3-text-blue" align="left"><b>User Password</b></label>
	                                <input type="text" id="passwd" class="form-control" name="passwd" value="${user.passwd}"/>
	                            </div>
	                            <div class="form-group">
	                            	<label class="w3-text-blue" align="left"><b>User Email</b></label>
	                                <input type="text" id="email" class="form-control" name="email" value="${user.email}"/>
	                            </div>
	                            <div class="form-group">
	                            	<label class="w3-text-blue" align="left"><b>User Mobile</b></label>
	                                <input type="text" id="mobile" class="form-control" name="mobile" value="${user.mobile}"/>
	                            </div>
                        	</div>
                        </div>
                    </div>
                    <button type="submit" class="btnSubmit" id="submit" onclick="alert('Complete')">Submit</button>
                    <button type="button" class="cancle btnSubmit" onlick="location.href='http://3.34.77.179:8080/main-1.0.0-BUILD-SNAPSHOT/main/home'">Cancle</button>
                </div>
             </form>
             
            </div>
        </div>
	</div>
</body>
</html>
