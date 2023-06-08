<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
    <form name="insertFrom" action="boardInsert" method="post">
        <div>
            <h3>게시글 정보</h3>
        </div>
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" name="" ></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="" ></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="" ></textarea></td>
            </tr>
            <tr>
                <th>첨부이미지</th>
                <td><input type="text" name="" ></td>
            </tr>
        </table>
        <button type="submit">등록</button>
        <button type="button">목록</button>
    </form>
</body>
</html>