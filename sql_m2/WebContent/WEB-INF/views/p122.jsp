<!-- 2018. 8. 6(월) 이원상 p122.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prefix의 c는 태그를 사용할 때 항상 붙는 접두어, 다른 문자 ok, 하지만 c를 사용하는 것이 약속.. -->
<!-- uri태크는 라이브러리가 존재하는 위치를 의미함 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>p122</title>
</head>
<body>
	<div class="page-header">
  		<h1>SQL이 보이는 그림책으로 모델2 만들기 <small>p122</small></h1>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>케이크 이름</th>
				<th>케이크 가격</th>
			</tr>
		</thead>
		<tbody>												<!-- EL은 jsp의 표현식을 $중괄호로 표현함. -->
			<c:forEach items="${list}" var="c">				<!-- item속성 : 배열형태의 객체를 지정, var : 변수명 -->
			<tr>											<!-- forEach는 자바의 for문과 같음 -->
				<td>${c.name}</td>
				<td>${c.price}</td><br>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
</body>
</html>