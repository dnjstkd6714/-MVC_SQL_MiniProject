<!-- 2018. 8. 7(화) 이원상 p125.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>p125</title>
</head>
<body>
	<div class="page-header">
  		<h1>SQL이 보이는 그림책으로 모델2 만들기 <small>p125</small></h1>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>												<!-- jstl은 사용할 필요가 없어 생략하였음. -->
			<tr>											<!-- EL은 jsp의 표현식을 $중괄호로 표현함. -->
				<td>${requestScope.cakePrice}</td>			<!-- request영역의 변수를 표현, requestScope생략해도 무방 -->
			</tr>											<!-- 각 영영(session등)의 변수가 중복정의되지 않도록 주의해야함 -->
		</tbody>
	</table>	
</body>
</html>