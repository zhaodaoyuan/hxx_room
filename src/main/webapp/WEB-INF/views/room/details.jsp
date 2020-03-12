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
	
	
function change(){
	var id = $("#build_id").val();
	console.log(id)
	$.post('/room/roomajax',{id:id},function(data){
		for(var i in data){
			$("#room_id").append("<option value='"+data[i].room_id+"'>"+data[i].room_num+"</option>")
			
		}
	})
}
	
	function doupdate(){
		$.post('/room/tiaozheng',$("#form1").serialize(),function(flag){
			if(flag){
				alert("成功")
				location="/room/list"
			}
				
			})
	}
	
	function del(id){
		$.post('/room/delinto',{id:id},function(flag){
			if(flag){
				alert("该学生已经变为无寝室状态");
				location="/room/list"
			}
		})
		
	}
	
	function update(id){
		$("[name=student_id]").val(id);
		$("#model").modal('show')
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
			  <a href="/room/details" class="list-group-item list-group-item-action  active">寝室详情</a>
			  <a href="/rule/" class="list-group-item list-group-item-action">违纪管理</a>
			  <a href="/room/repair/" class="list-group-item list-group-item-action">寝室报修</a>
			</div>
		</div>
		
		<!-- 内容 -->
		<div class="col-9">
			    <div class="tab-content" id="content">
			      	<table class="table">
			      		<tr>
			      			<td>姓名</td>
			      			<td>学号</td>
			      			<td>专业</td>
			      			<td>床号</td>
			      			<td>性别</td>
			      			<td>操作</td>
			      		</tr>
			      		<c:forEach items="${list }" var="list">
			      			<tr>
				      			<td>${list.student_name }</td>
				      			<td>${list.student_num }</td>
				      			<td>${list.major_name }</td>
				      			<td>${list.bed_num }</td>
				      			<td>${list.student_sex==1?'男':'女' }</td>
				      			<td>
				      			
				      			<input class="btn btn-danger" type="button" value="移除此人" onclick="del(${list.student_id})">
				      			<input class="btn btn-primary" type="button" value="调整寝室" onclick="update(${list.student_id})">
				      			</td>
			      			</tr>
			      		</c:forEach>
			      		
			      	</table>
			      	
			      	<!-- 模态框 -->
			      	
			      	<div>
			      		<div class="modal" tabindex="-1" role="dialog" id="model">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title">Modal title</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        <form id="form1">
						        <input type="hidden" name="student_id">
						        	<p>公寓楼号</p>
						        	<select class="form-control" onchange="change()" name="build_id" id="build_id">
						        		<option value="">请选择</option>
						        		<c:forEach items="${buildlist }" var="list">
						        			<option value="${list.build_id }">${list.build_name }</option>
						        		</c:forEach>
						        	</select>
						        		
						        	<p>寝室号码</p>
						        	<select  class="form-control" id="room_id" name="room_id">
						        		<option value="">请选择</option>
						        	</select>
						        	<p>床位号</p>
						        	<select class="form-control" id="bed_id" name="bed_id">
						        		<option value="">请选择</option>
						        		<c:forEach items="${bedlist }" var="bedlist">
						        			<option value="${bedlist.bed_id }">${bedlist.bed_num }</option>
						        		</c:forEach>
						        	</select>
						        </form>
						      </div>
						      <div >
						        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						        <input type="button" class="btn" value="调整" onclick="doupdate()">
						      </div>
						    </div>
						  </div>
						</div>
			      	</div>
			      	
			      	
			      	
			      	
  				</div>
		</div>
		
	</div>
</div>
</body>
</html>