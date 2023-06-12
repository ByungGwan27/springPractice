<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서별 대여매출현황</title>
<style>
	thead th, .no { text-align: center;}
	.text { text-align: left;}
	.number {text-align: right;}
</style>
</head>
<body>
	<div>
		<h2>도서별 대여매출현황</h2>
		<table>
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>대여총계</th>
					<th>대여횟수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rentList }" var="rentInfo">
					<tr>
						<td class="no">${rentInfo.bookNo }</td>
						<td class="text">${rentInfo.bookName }</td>
						<td class="number">${rentInfo.rentTotalPrice }</td>
						<td class="number">${rentInfo.rentCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>