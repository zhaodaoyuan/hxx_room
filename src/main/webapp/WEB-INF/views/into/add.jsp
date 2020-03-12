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
$(function(){
	$.post("/student/ajax",null,function(data){
		for(var i in data){
			if(data[i].status!=1){
				$("#studentlsit").append("<td>"+data[i].student_num+"</td><td>"+data[i].student_name+"</td><td><input type='button' class='btn btn-success' value='选择' onclick='show("+data[i].student_id+")'></td></tr>");
			}
			
		}
	})
	
})

function changeroom(){
	var id = $("#build_id").val();
	$.post('/room/roomajax',{id:id},function(data){
		$("#room_id").empty()
		for(var i in data){
			$("#room_id").append("<option value='"+data[i].room_id+"'>"+data[i].room_num+"</option>")
			
		}
	})
}
	function add(){
		$.post('/room/into/doadd',$("#form1").serialize(),function(flag){
			if(flag){
				alert("添加成功")
				location="/room/";
			}else{
				alert("该床铺已经有人了")
			}
		})
	}
	
	function show(id){
		$.post('/student/ajaxByid',{id:id},function(data){
			$("#sname").html();
			$("#sname").html(data.student_name);
			$("#show").css("display","block");
			$("#student_id").val(data.student_id)
			alert($("#student_id").val())
		})
		
		
	}
	
	function selectlist(){
		$.post("/student/ajax",{student_name:$("#student_name").val()},function(data){
			$("#studentlsit").empty()
			for(var i in data){
				if(data[i].status==0){
					$("#studentlsit").append("<tr><td>"+data[i].student_num+"</td><td>"+data[i].student_name+"</td><td><input type='button' class='btn btn-success' value='选择' onclick='show("+data[i].student_id+")'></td></tr>");
				}
				
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
			  <a href="/student/add" class="list-group-item list-group-item-action  active">入住登记</a>
			  <a href="/rule/" class="list-group-item list-group-item-action">违纪管理</a>
			  <a href="/room/repair/" class="list-group-item list-group-item-action">寝室报修</a>
			</div>
		</div>
		
		<!-- 内容 -->
		<div class="col-9">
			    <div class="tab-content row" id="content">
			    	<div class="col-4" >
			    		<div class="form-group">
					    
					    <input type="text" class="form-control" id="student_name" name="student_name" onchange="selectlist()">
					 	 </div>
					 	 <div style="overflow:auto; height: 700px;">
					 	 	<table id="studentlsit" class="table">
					 	 		
					 	 	</table>
					 	 </div>
					  
			    	</div>
			    	<div class="col-8 " id="show" style="display: none;">
				    	<form id="form1">
				    	<input type="hidden" name="student_id" id="student_id" >
				    	
				    	<div class="form-control bg-primary">
				    		<h4 id="sname" style="color:white;"></h4>
				    	</div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">公寓楼号</label>
						    <select name="build_id" id="build_id" class="form-control" onchange="changeroom()">
						    <option value="">请选择</option>
						    	<c:forEach items="${list }" var="list">
						    		<option value=${list.build_id }>${list.build_name }</option>
						    	</c:forEach>
						    </select>
						  </div>
						  
						  
						  <div class="form-group">
						    <label for="exampleInputPassword1">寝室号码</label>
						    <select name="room_id" id="room_id" class="form-control">
						    <option value="">请选择</option>
						    	
						    </select>
						  </div>
						  
						  
						  <div class="form-group">
						    <label for="exampleInputPassword1">床位号码</label>
						    <select name="bed_id" class="form-control">
						    <option value="">请选择</option>
						    	<c:forEach items="${bedlist }" var="list">
						    		<option value=${list.bed_id }>${list.bed_num }</option>
						    	</c:forEach>
						    </select>
						  </div>
						 
						  <input type="button" value="新建" class="btn btn-success" onclick="add()">
						</form>
			    	</div>
			      	
  				</div>
		</div>
		
	</div>
</div>
</body>
</html>