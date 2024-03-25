<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<h2>도서 조회/수정</h2>
	<table border="1">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>표지</th>
			<th>출판일자</th>
			<th>금액</th>
			<th>출판사</th>
			<th>도서소개</th>
		</tr>
		<c:forEach var="book" items="${list}">
			<tr>
				<td>${book.bookNo }</td>
				<td>${book.bookName }</td>
				<td><img style="width: 50px"
					src="resources/images/${book.bookCoverimg}" alt="책 표지"></td>
				<td><fmt:formatDate value="${book.bookDate}"
						pattern="yyyy/MM/dd" /></td>
				<td><fmt:formatNumber value="${book.bookPrice }"
						pattern="#,###" /></td>
				<td>${book.bookPublisher }</td>
				<td>${book.bookInfo }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>