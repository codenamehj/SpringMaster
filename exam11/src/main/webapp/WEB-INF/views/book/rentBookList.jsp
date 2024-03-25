<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<table border="1">
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>대여총계</td>
			<td>대여횟수</td>
		</tr>
		<c:forEach var="rent" items="${rentlist}">
			<tr>
				<td>${rent.bookNo}</td>
				<td>${rent.bookName}</td>
				<td>${rent.sum}</td>
				<td>${rent.cnt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>