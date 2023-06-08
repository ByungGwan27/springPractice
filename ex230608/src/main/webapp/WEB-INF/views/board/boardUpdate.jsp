<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
    <form name="updateFrom" action="boardUpdate" method="POST">
        <div>
            <h3>게시글 수정</h3>
        </div>
        <table>
            <tr>
                <th>번호</th>
                <td><input type="number" name="bno" value="${board.bno }" readonly></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="" value="${board.title }" readonly></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="" value="${board.writer }" readonly></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name=""></textarea></td>
            </tr>
            <tr>
                <th>첨부파일</th>
                <td><input type="text" name="" value="${board.image }" readonly></td>
            </tr>
            <tr>
                <th>수정날짜</th>
                <td><input type="date" name="" value="${board.updatedate }" readonly></td>
            </tr>
        </table>
        <button type="submit">수정완료</button>
        <button type="button">취소</button>
    </form>
</body>
</html>