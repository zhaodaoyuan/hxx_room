<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	function update(id){
		location="/student/update?id="+id
	}
	
	function del(id){
		$.post('/student/del',{id:id},function(flag){
			if(flag){
				alert("成功删除");
				location="/student/list"
			}
		})
		
	}
	function gotoPage(pageNo){
		$("[name=pageNum]").val(pageNo);
		$("form").submit();
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
			  <a href="/student/list" class="list-group-item list-group-item-action  active">学生列表</a>
			  <a href="/room/" class="list-group-item list-group-item-action">寝室管理</a>
			  <a href="/rule/" class="list-group-item list-group-item-action">违纪管理</a>
			  <a href="/room/repair/" class="list-group-item list-group-item-action">寝室报修</a>
			</div>
		</div>
		
		<!-- 内容 -->
		<div class="col-9">
			    <div class="tab-content" id="content">
			      	<table class="table">
			      		
			      	<tr>
			      	<form>
			      	<input type="hidden" name="pageNum">
			      		<td>学生姓名</td>
			      		<td colspan="2"><input type="text" name="student_name" value="${student.student_name }"></td>
			      		<td>学生学号</td>
			      		<td colspan="2"><input type="text" name="student_num" value="${student.student_num }"></td>
			      		<td>
			      			<input type="button" value="搜索" onclick="gotoPage()">
			      		</td>
			      		</form>
			      	</tr>
			      		<tr>
			      			<td>学号</td>
			      			<td>姓名</td>
			      			<td>性别</td>
			      			<td>专业</td>
			      			<td>电话</td>
			      			<td>地址</td>
			      			<td>操作</td>
			      		</tr>
			      		<c:forEach items="${pageInfo.list }" var="list">
			      			<tr>
				      			<td>${list.student_num }</td>
				      			<td>${list.student_name }</td>
				      			<td>${list.student_sex==1?'男':'女' }</td>
				      			<td>${list.major_name }</td>
				      			<td>${list.student_phone }</td>
				      			<td>${list.student_adress }</td>
				      			<td>
				      			<input class="btn btn-warning" type="button" value="修改" onclick="update(${list.student_id})">
				      			<input class="btn btn-danger" type="button" value="删除" onclick="del(${list.student_id})">
				      			</td>
			      			</tr>
			      		</c:forEach>
			      		
			      	</table>
			      	<div class="col-sm-12" style="margin-top: 10px;"><jsp:include page="../common/page.jsp"></jsp:include></div>
  				</div>
		</div>
		
	</div>
</div>
</body>
</html>