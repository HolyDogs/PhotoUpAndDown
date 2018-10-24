<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; utf-8">
<title>Main</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/jquery-3.2.1.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>

<!-- 引用控制层插件样式 -->

<link rel="stylesheet" href="css/zyUpload.css" type="text/css">

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<!-- 引用核心层插件 -->

<script src="core/zyFile.js"></script>

<!-- 引用控制层插件 -->

<script src="js/zyUpload.js"></script>

<!-- 引用初始化JS -->

<script src="core/jq22.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$(".mybtnd").click(function(){
		var str=this.value;
		$.post("lover/deleteL",{"id":str},function(data){
			alert(data);
			$("#div"+str).hide();
		});
	});
	
});
function lookl(str){
	
	
};

function deletel(str){
	$(function(){
		$.post("/lover/deleteL",{"id":str},function(data){
			alert(data);
			$("#div"+str).hide();
		});
	});
};



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
										<button class="btn btn-xs btn-info mybtns" value="${lover.id }">查看</button>
										<button class="btn btn-danger btn-xs mybtnd" value="${lover.id }">删除</button>
								</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
			
			 <a id="modal-97820" href="#modal-container-97820" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>
			
			<div class="modal fade" id="modal-container-97820" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								标题
							</h4>
						</div>
						<div class="modal-body">
							内容...
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>
</div>
</body>
</html>