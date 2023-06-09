<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
    <form name="insertForm" action="boardInsert" method="post" onsubmit="return false;">
        <div>
            <h3>게시글 정보</h3>
        </div>
        <table>
            <tr>
                <th>제목*</th>
                <td><input type="text" name="title" ></td>
            </tr>
            <tr>
                <th>작성자*</th>
                <td><input type="text" name="writer" ></td>
            </tr>
            <tr>
                <th>내용*</th>
                <td><textarea name="contents" ></textarea></td>
            </tr>
            <tr>
                <th>첨부이미지</th>
                <td><input type="text" name="image" ></td>
            </tr>
        </table>
        <button type="submit">등록</button>
        <button type="button" onclick="location.href='boardList'">목록</button>
    </form>
</body>
<script>
	document.querySelector('form[name="insertForm"]')
			.addEventListener('submit', function(e){
				e.preventDefault();

                let tt = document.getElementsByName("title")[0];
                if(tt.value=="") {
                    alert('title null!');
                    tt.focus();
                    return false;
                }
                
                let wt = document.getElementsByName("writer")[0];
                if(wt.value=="") {
                    alert('writer null!');
                    wt.focus();
                    return false;
                }
                
                let ct = document.getElementsByName("contents")[0];
                if(ct.value=="") {
                    alert('contents null!');
                    ct.focus();
                    return false;
                }

                insertForm.submit();
			})

</script>
</html>