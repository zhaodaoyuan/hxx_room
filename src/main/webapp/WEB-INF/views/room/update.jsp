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
	function add(){
		$.post('/room/doupdate',$("form").serialize(),function(flag){
			if(flag){
				alert("修改成功")
				location="/room/list";
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
			  <a href="/room/" class="list-group-item list-group-item-action">寝室管理</a>
			  <a href="/student/add" class="list-group-item list-group-item-action  active">修改寝室信息</a>
			  <a href="/rule/" class="list-group-item list-group-item-action">违纪管理</a>
			  <a href="/room/repair/" class="list-group-item list-group-item-action">寝室报修</a>
			</div>
		</div>
		
		<!-- 内容 -->
		<div class="col-9">
			    <div class="tab-content" id="content">
			      	<form>
					  <div class="form-group">
					    <label for="exampleInputEmail1">寝室号码</label>
					    <input type="text" class="form-control" id="room_num" name="room_num" value="${room.room_num }">
					  </div>

					  <div class="form-group">
					    <label for="exampleInputPassword1">公寓楼号</label>
					    <select name="build_id" class="form-control">
					    <option value="">请选择</option>
					    	<c:forEach items="${list }" var="list">
					    		<option <c:if test="${list.build_id==room.build_id }">selected</c:if> value=${list.build_id }>${list.build_name }</option>
					    	</c:forEach>
					    </select>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">寝室居住人数</label>
					    <input type="text" name="room_size" class="form-control" value="${room.room_size }" >
					  </div>
					  <input type="button" value="新建" class="btn btn-success" onclick="add()">
					</form>
  				</div>
		</div>
		
	</div>
</div>
</body>
</html>