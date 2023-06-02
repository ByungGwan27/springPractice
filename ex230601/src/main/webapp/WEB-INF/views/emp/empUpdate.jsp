<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사원수정</h3>
 <form action="empUpdate" method="post" name="frm">
 	 employeeid<input name="employeeId" readonly="readonly" value="${emp.employeeId }"><br>
	 fname<input name="firstName" value="${emp.firstName}"><br>
	 lname*<input name="lastName" value="${emp.lastName}"><br>
	 hiredate*<input name="hireDate" value="${emp.hireDate}"><br>
	 email*<input name="email" value="${emp.email}"><br>
	 departmentId
	 	<c:forEach items="${depts}" var="dept">
	 		<input type="radio" name="departmentId"
	 			value="${dept.departmentId}" <c:if test="${dept.departmentId == emp.departmentId}">checked</c:if> >
	 			${dept.departmentName}
	 	</c:forEach><br>
	 jobId*<select name="jobId">
	 	<option value="">--선택--
	 	<c:forEach items="${jobs}" var="jj">
	 		<!-- key값은 오라클로 보이는 결과창 == 전부 대문자, 마이바티스에서 as걸어주면 as 걸어준대로 써야함 -->
	 		<option value="${jj.jobId}">${jj.jobTitle} 
	 	</c:forEach>
	 </select><br>
	 <button>저장</button>
 </form>
 <script>
 	//자동 체크
 	//frm.departmentId.value = "${emp.departmentId}"
 	frm.jobId.value = "${emp.jobId}"
 </script>
</body>
</html>