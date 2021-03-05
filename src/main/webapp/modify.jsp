<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link href="./css/index2.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="ModifyData" method="post">
    <table border="1">
        <caption>수정하기</caption>
        <tbody>
        <tr>
            <td><label for="title">제목</label>
            <td><input type="text" name="title" id="title" value="${sessionScope.view.title}"></td>
        </tr>
        <tr>
            <td><label for="name">이름</label>
            <td><input type="text" name="name" id="name" value="${sessionScope.view.name}"></td>
        </tr>
        <tr>
            <td>작성일</td>
            <td><div>${sessionScope.view.wTime}</div></td>
        </tr>
        <tr>
            <td colspan="2" class="contents"><input type="text" name="contents" value="${sessionScope.view.contents}"></td>
        </tr>
        </tbody>
    </table>
    <div>
        <input type="button" value="목록" onclick="location.href='/index.jsp'">
        <input type="submit" value="등록">
    </div>
</form>
</body>
</html>
