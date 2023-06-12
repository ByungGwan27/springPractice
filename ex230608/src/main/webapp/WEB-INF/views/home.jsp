<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	<style>
		 body {background-image:url("resources/images/돈담곰.jpg");
         /* background-repeat:no-repeat; */ 
         /* background-size: cover; */
         text-align:center;
        }
	</style>
</head>
<body>
<h1>
	Hello world!!  
</h1>
<a href="boardList">boardList</a>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
