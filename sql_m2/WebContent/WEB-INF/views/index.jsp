<!-- 2018. 8. 6(월) 이원상 index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>index.jsp</title>								<!--Controller : IndexController -->
														<!--View : index.jsp-->
</head>
<body>
	<div class="page-header">
  		<h1>SQL이 보이는 그림책으로 모델2 만들기 <small>index</small></h1>
	</div>
	<ol>
		<li><a href="<%=request.getContextPath() %>/P122Controller">p122쿼리 사용 페이지 요청</a></li>
		<li><a href="<%=request.getContextPath() %>/P124Controller">p124쿼리 사용 페이지 요청</a></li>
		<li><a href="<%=request.getContextPath() %>/P125Controller">p125쿼리 사용 페이지 요청</a></li>
	</ol>
</body>
</html>