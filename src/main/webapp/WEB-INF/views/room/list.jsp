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
		location="/room/update?id="+id
	}
	
	function del(id){
		$.post('/room/del',{id:id},function(flag){
			if(flag){
				alert("成功删除");
				location="/room/list"
			}
		})
		
	}
	function room(id){
		location="/room/details?id="+id;
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
			  <a href="/room/" class="list-group-item list-group-item-action">寝室管理</a>
			  <a href="/room/list" class="list-group-item list-group-item-action  active">寝室列表</a>
			  <a href="/rule/" class="list-group-item list-group-item-action">违纪管理</a>
			  <a href="/room/repair/" class="list-group-item list-group-item-action">寝室报修</a>
			</div>
		</div>
		
		<!-- 内容 -->
		<div class="col-9">
			    <div class="tab-content" id="content">
			      	<table class="table">
			      	<form>
			      	<input type="hidden" name="pageNum">
			      		<td>公寓号码</td>
			      		<td colspan="2"><select name="build_id">
			      			<c:forEach items="${list }" var="list">
			      				<option value="${list.build_id }" <c:if test="${list.build_id==room.build_id }">selected</c:if> >${list.build_name }</option>
			      			</c:forEach>
			      		</select></td>
			      		<td>
			      			<input type="button" value="搜索" onclick="gotoPage()">
			      		</td>
			      		</form>
			      		<tr>
			      			<td>寝室号码</td>
			      			<td>公寓号码</td>
			      			<td>房间可居住人数</td>
			      			<td>房间已居住人数</td>
			      			<td>操作</td>
			      		</tr>
			      		<c:forEach items="${pageInfo.list }" var="list">
			      			<tr>
				      			<td>${list.room_num }</td>
				      			<td>${list.build_name }</td>
				      			<td>${list.room_size }</td>
				      			<td>${list.real_size }</td>
				      			<td>
				      			<input class="btn btn-warning" type="button" value="修改" onclick="update(${list.room_id})">
				      			<input class="btn btn-danger" type="button" value="删除" onclick="del(${list.room_id})">
				      			<input class="btn btn-success" type="button" value="管理" onclick="room(${list.room_id})">
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