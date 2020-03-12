<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/cms.css" rel="stylesheet">
<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	function login(){
		$.post('/dologin',$("#loginForm").serialize(),function(flag){
			if(flag){
				alert("成功");
				location="/index/";
			}else{
				alert("123")
			}
		})
		
	}
</script>
<body>
	<div class="container-fluid">
		<div class="col-4 offset-4 loginForm">
			<h3>欢迎回来</h3>
			<div class="alert alert-danger" role="alert" style="display: none">
			</div>
			<form id="loginForm">
			  <div class="form-group">
			    <input type="text" id="admin_name" name="username" class="form-control" placeholder="请输入用户名...">
			    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			  </div>
			  <div class="form-group">
			    <!-- <label for="exampleInputPassword1">密码</label> -->
			    <input type="password" id="admin_pwd" name="password" class="form-control"  placeholder="请输入密码..."">
			  </div>
			  <button type="button" class="btn btn-primary" onclick="login();">登录</button>
			  
			</form>
		</div>
	</div>
</body>
</html>