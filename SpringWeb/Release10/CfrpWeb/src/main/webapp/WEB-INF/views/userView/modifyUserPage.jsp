<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>내 정보 수정 페이지</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
 	<div class="container-fluid">
		<div class="container register-form">
            <div class="form">
                <div class="note">
                    <p>내 정보 수정</p>
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
