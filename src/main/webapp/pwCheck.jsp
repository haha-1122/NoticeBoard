<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="PWCheck" method="post">
    <table>
        <tr>
            <td><label for="pw">비밀번호 확인</label></td>
            <td><input type="password" id="pw" name="pw"></td>
            <td><input type="submit" value="확인"></td>
            <input type="hidden" name="op" value="${param.op}">
        </tr>
    </table>
</form>
</body>
</html>
