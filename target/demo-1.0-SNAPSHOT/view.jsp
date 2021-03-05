<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link href="./css/index2.css" rel="stylesheet" type="text/css">
</head>
<body>
<table border="1">
    <caption>내용보기</caption>
    <tbody>
    <tr>
        <td>제목</td>
        <td>${sessionScope.view.title}</td>
    </tr>
    <tr>
        <td>이름</td>
        <td>${sessionScope.view.name}</td>
    </tr>
    <tr>
        <td>작성일</td>
        <td>${sessionScope.view.wTime}</td>
    </tr>
    <tr>
        <td colspan="2" class="contents">${sessionScope.view.contents}</td>
    </tr>
    </tbody>
</table>
<a href="/index.jsp">목록</a>
<a href="/pwCheck.jsp?op=0">수정</a>
<a href="/pwCheck.jsp?op=1">삭제</a>
</body>
</html>
