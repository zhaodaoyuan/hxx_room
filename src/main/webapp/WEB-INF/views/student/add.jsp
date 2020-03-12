<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript">
	function add(){
		$.post('/student/doadd',$("form").serialize(),function(flag){
			if(flag){
				alert("添加成功")
				location="/student/";
			}
		})
	}
</script>
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
			  <a href="/student/add" class="list-group-item list-group-item-action  active">新建学生信息</a>
			  <a href="/room/" class="list-group-item list-group-item-action">寝室管理</a>
			  <a href="/rule/" class="list-group-item list-group-item-action">违纪管理</a>
			  <a href="/room/repair/" class="list-group-item list-group-item-action">寝室报修</a>
			</div>
		</div>
		
		<!-- 内容 -->
		<div class="col-9">
			    <div class="tab-content" id="content">
			      	<form>
					  <div class="form-group">
					    <label for="exampleInputEmail1">姓名</label>
					    <input type="text" class="form-control" id="student_name" name="student_name">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">学号</label>
					    <input type="text" name="student_num" class="form-control" >
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">性别</label>
					    <select class="form-control" name="student_sex">
					    <option value="">请选择</option>
					    <option value="1">男</option>
					    <option value="0">女</option>
					    </select>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">学生专业</label>
					    <select name="major_id" class="form-control">
					    <option value="">请选择</option>
					    	<c:forEach items="${list }" var="list">
					    		<option value=${list.major_id }>${list.major_name }</option>
					    	</c:forEach>
					    </select>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">学生电话</label>
					    <input type="text" name="student_phone" class="form-control" >
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">学生住址</label>
					    <input type="text" name="student_adress" class="form-control" >
					  </div>
					  <input type="button" value="新建" class="btn btn-success" onclick="add()">
					</form>
  				</div>
		</div>
		
	</div>
</div>
</body>
</html>