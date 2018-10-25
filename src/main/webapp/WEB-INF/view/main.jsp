<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; utf-8">
<title>Main</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.js" type="text/javascript"></script>

<!-- 引用控制层插件样式 -->

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/zyUpload.css" type="text/css">

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<!-- 引用核心层插件 -->

<script src="${pageContext.request.contextPath }/core/zyFile.js"></script>

<!-- 引用控制层插件 -->

<script src="${pageContext.request.contextPath }/js/zyUpload.js"></script>

<!-- 引用初始化JS -->

<script src="${pageContext.request.contextPath }/core/jq22.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$(".mybtnd").click(function(){
		var str=this.value;
		$.post("${pageContext.request.contextPath}/lover/deleteL",{"id":str},function(data){
			alert(data);
			$("#div"+str).hide();
		});
	});
	
	
	
	$("#btntj").click(function(){
		
		var form=new FormData(document.getElementById("forml"));
		$.ajax({
			url:"${pageContext.request.contextPath}/lover/addl",
			type:"post",
 			processData:false,
			contentType:false,
			data:form,
			success:function(data){
				alert(data);
				window.location.reload()
			},
			error:function(){
				alert("添加失败");
			}
			
		}); 
	});
});

</script>



</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-8 column">
			<div class="page-header">
				<h1>
					我的信息
				</h1>
				<a href="${pageContext.request.contextPath }/logout" class="btn btn-xs btn-info">登出</a>
			</div>
			<div class="row clearfix">
					<div class="col-md-7 column">
							 <div class="page-header">
						<h1>
							<small>我的头像</small>
						</h1>
					</div>
					 <img width="450" height="450" src="${pageContext.request.contextPath }/img/gethead" />
					 <div id="demo" class="demo"></div>
				</div>
				<div class="col-md-5 column">
					 <div class="page-header">
						<h1>
							<small>我的介绍</small>
						</h1>
					</div>
					 <ul>
						<li>
							我的ID:${user.id }
						</li>
						<li>
							我的生日:${user.birth }
						</li>
						<li>
							我的名字:${user.name }
						</li>
					</ul>
				</div>	
			</div>
		</div>
		<div class="col-md-4 column">
			<div class="page-header">
				<h1>
					联系人
				</h1>

			</div>
			<table class="table table-striped table-condensed table-hover">
				<thead>
					<tr>
						<th>
							id
						</th>
						<th>
							name
						</th>
						<th>
							birth
						</th>
						<th>
							act
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lovers }" var="lover">
							<tr id="div${lover.id }">
								<td>
									${lover.id }
								</td>
								<td>
									${lover.name }
								</td>
								<td>
									${lover.birth }
								</td>
								<td>
										<form action="${pageContext.request.contextPath }/lover/randomImg" method="post"><button type="submit" name="btn" class="btn btn-xs btn-info" value="${lover.id }">查看</button></form>
										<button class="btn btn-danger btn-xs mybtnd" value="${lover.id }">删除</button>
								</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			
			 <a id="modal-97820" href="#modal-container-97820" role="button" class="btn" data-toggle="modal">添加联系人</a>
			
			<div class="modal fade" id="modal-container-97820" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								
							</h4>
						</div>
						<form id="forml">
						<div class="modal-body">
							<div class="form-group">
							
								<input name="lname" class="form-control" class="" placeholder="name"/>
								<ul>
									    <li align="center">
											<h2>&nbsp;年&nbsp;&nbsp;  &nbsp;	 月 	     	  		日</h2>
								        </li>
								        <li align="center">
											<select name="year">
												<option>2018</option>
												<%
													for(int i=1;i<40;i++){
														out.print("<option>"+(2018-i)+"</option>");
													}
												%>
											</select>
											<select name="month">
												<%
													for(int i=1;i<13;i++){
														if(i<10){
															out.print("<option>"+"0"+i+"</option>");
														}else{
														out.print("<option>"+i+"</option>");
														}
													}
												%>
											</select>
											<select name="day">
												<%
													for(int i=1;i<32;i++){
														
														if(i<10){
															out.print("<option>"+"0"+i+"</option>");
														}else{
														out.print("<option>"+i+"</option>");
														}
													}
												%>
											</select>
								        </li></ul>
							</div>
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" id="btntj" class="btn btn-primary">添加</button>
						</div>
						</form>
					</div>
					
				</div>
				
			</div>

		</div>

	</div>

</div>
</body>
</html>