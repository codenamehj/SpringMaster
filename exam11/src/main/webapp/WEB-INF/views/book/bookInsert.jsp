<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookInsert.jsp</title>
</head>
<body>
	<h2>도서대여관리</h2>
	<nav>
		<ul>
			<li><a href="insert">도서등록</a></li>
			<li><a href="list">도서목록조회/수정</a></li>
			<li><a href="rentlist">대여현황조회</a></li>
			<li><a href="index">홈으로</a></li>
		</ul>
	</nav>
	<h2>도서 등록</h2>
	<form name="frm" onSubmit="return checkForm()" action="/mb/insert"
		method="post">
		<table>
			<tr>
				<td>도서번호</td>
				<td><input placeholder="등록하면 자동으로 입력됩니다." type="number" name="bookNo" value="bookNo" readonly></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><input type="text" id="bookName" name="bookName"></td>
			</tr>
			<tr>
				<td>도서표지</td>
				<td><input type="text" name="bookCoverimg"></td>
			</tr>
			<tr>
				<td>출판일자</td>
				<td><input type="date" name="bookDate"></td>
			</tr>
			<tr>
				<td>금액</td>
				<td><input type="number" name="bookPrice"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="bookPublisher"></td>
			</tr>
			<tr>
				<td>도서소개</td>
				<td><textarea name="bookInfo"></textarea></td>
			</tr>
		</table>
		<div>
			<button>등록</button>
		</div>
	</form>
	<script type="text/javascript">
		function checkForm() {
			if (frm.bookName.value == "") {
				frm.bookName.focus();
				alert("도서명이 입력되지 않았습니다.");
				return false;
			}else if(frm.bookCoverimg.value == ""){
				frm.bookCoverimg.focus();
				alert("도서표지가 입력되지 않았습니다.");
				return false;
			}else if(frm.bookDate.value == ""){
				frm.bookDate.focus();
				alert("출판일자가 입력되지 않았습니다.");
				return false;
			}else if(frm.bookPrice.value == ""){
				frm.bookPrice.focus();
				alert("금액이 입력되지 않았습니다.");
				return false;
			}else if(frm.bookPublisher.value == ""){
				frm.bookPublisher.focus();
				alert("출판사가 입력되지 않았습니다.");
				return false;
			}else if(frm.bookInfo.value == ""){
				frm.bookInfo.focus();
				alert("도서소개가 입력되지 않았습니다.");
				return false;
			}else{
				alert("도서등록이 완료되었습니다.");
				return true;
			}
		}
	</script>
</body>
</html>