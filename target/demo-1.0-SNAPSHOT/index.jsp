<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="./css/index2.css" type="text/css">
</head>
<body>
    <table border="1">
        <caption>목록</caption>
        <thead>
            <tr>
                <td>번호</td>
                <td>제목</td>
                <td>작성자</td>
                <td>작성일</td>
                <td>조회수</td>
            </tr>
        </thead>
        <tbody>
            ${repository}
        </tbody>
    </table>
    <a href="writer.jsp">글쓰기</a>
</body>
</html>