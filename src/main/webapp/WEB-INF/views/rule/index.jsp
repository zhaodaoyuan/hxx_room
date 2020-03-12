<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/model.css" rel="stylesheet">
<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/public/js/ajaxfileupload.js"></script>
</head>
<body>
<!-- head -->
<div class="container-fluid row head">
	
</div>
<!-- body -->
<div class="container-fluid" style="margin-top: 30px;">
	<div class="row">
		<!-- 左侧导航 -->	
		<div class="col-3">
			<div class="list-group">
			  <a href="/index" class="list-group-item list-group-item-action">主页</a>
			  <a href="/student/" class="list-group-item list-group-item-action">学生管理</a>
			  <a href="/room/" class="list-group-item list-group-item-action">寝室管理</a>
			  <a href="/rule/" class="list-group-item list-group-item-action active">违纪管理</a>
			  <a href="/room/repair/" class="list-group-item list-group-item-action">寝室报修</a>
			</div>
		</div>
		
		<!-- 内容 -->
		<div class="col-9">
			    <div class="tab-content" id="content">
			       <div class="tab-content" id="content">
			      	<a class="col-1" href="/rule/list" style="float: left;">
			      	<img class="img-icon"  src="/public/img/studentlist.jpg" style="width:100%;" >
			      	</br>
			      	<span style="margin:10%;">违纪总览</span>
			      	</a>
			      	<a class="col-1" href="/rule/add" style="float: left;">
			      	<img class="img-icon" src="/public/img/addstudent.jpg"  style="width: 100%;"  >
			      	</br>
			      	<span style="margin:10%;">违纪录入</span>
			      	</a>
  				</div>
  				</div>
		</div>
		
	</div>
</div>

</body>
</html>