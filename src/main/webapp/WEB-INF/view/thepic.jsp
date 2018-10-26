<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; utf-8">
<title>PIC</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.js" type="text/javascript"></script>

</head>
<body>
<div class="container">
	<div class="row clearfix">
	<div class="col-md-2 column">
		<a class="btn btn-lg btn-info" href="${pageContext.request.contextPath }/lover/back">返回</a>
		<a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath }/img/download">下载图片</a>
	</div>
	
		<div class="col-md-8 column">
			<img style="margin-top:50px;" src="${pageContext.request.contextPath }/img/randompic" />	
		</div>
	</div>
</div>


</body>
</html>