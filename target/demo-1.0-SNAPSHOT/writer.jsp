<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>글쓰기</title>
    <link href="./css/index2.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="InputData" method="post">
    <table border="1">
        <caption>글쓰기</caption>
        <tbody>
        <tr>
            <td><label for="title">제목</label></td>
            <td><input type="text" id="title" name="title"></td>
        </tr>
        <tr>
            <td><label for="name">이름</label></td>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td><label for="pw">비밀번호</label></td>
            <td><input type="password" id="pw" name="pw"></td>
        </tr>
        <tr>
            <td><label for="email">이메일</label></td>
            <td><input type="email" id="email" name="email"></td>
        </tr>
        <tr>
            <td colspan="2" class="contents"><input type="text" name="contents"></td>
        </tr>
        </tbody>
    </table>
    <div>
        <input type="submit" value="등록">
        <input type="button" value="목록" onclick="location.href='index.jsp'">
    </div>
</form>
</body>
</html>
