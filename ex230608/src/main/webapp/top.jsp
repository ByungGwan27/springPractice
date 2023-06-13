<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <sec:csrfMetaTags/> --%> <!-- sec 내장태그로 토큰값 넘겨줌 -->
<title>Insert title here</title>
</head>
<body>
	<!-- 25p 이후 -->
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>
	
	
	<sec:authorize access="isAuthenticated()">
		<form action="logout" method="post">
		<sec:csrfInput/>
			<button>로그아웃</button>
		</form>
	</sec:authorize>
	
	<input type="hidden" name="csrf_name" value="${_csrf.parameterName }">
	<input type="hidden" name="csrf_val" value="${_crf.token }">
</body>
</html>