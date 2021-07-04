<!-- registerUser -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	top:30%;
	left:15%;
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
</head>


<body>
	<div class="container-fluid">
		<div class="container register-form">
            <div class="form">
                <div class="note">
                    <p>회원가입</p>
                </div>

			<form action="/registProcess" method="post">
                <div class="form-content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Id *" name="id"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Password *" name="passwd"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Email *" name="email"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Mobile *" name="mobile"/>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btnSubmit">Submit</button>
                </div>
             </form>
            </div>
        </div>
	</div>
</body>
</html>