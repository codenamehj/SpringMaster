<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://unpkg.com/tabulator-tables/dist/css/tabulator.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="https://unpkg.com/tabulator-tables/dist/js/tabulator.min.js"></script>
</head>
<body>
	<h2>도서대여관리</h2>
	<nav>
		<ul>
			<li><a href="insert">도서등록</a></li>
			<li><a href="list">도서목록조회/수정</a></li>
			<li><a href="rentlist">대여현황조회</a></li>
			<li><a href="/mb">홈으로</a></li>
		</ul>
	</nav>
	<h2>도서별 대여매출현황</h2>
	<div id="result-data"></div>
	<script type="text/javascript">
	console.log(${rentJsonList});
	let resultData = new Tabulator("#result-data",{
	    layout:"fitDataTable",
		data:${rentJsonList},
		columns:[
			{title:"도서번호", field:"bookNo"},
			{title:"도서명", field:"bookName"},
			{title:"대여총계", field:"sum"},
			{title:"대여횟수", field:"cnt"}
		],
	});
	</script>
</body>
</html>