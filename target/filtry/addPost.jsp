<%--
  Created by IntelliJ IDEA.
  User: jazwa
  Date: 2019-03-23
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj post</title>
</head>
<body>
<form action="/addpost" method="post">
    Tytul: <input type="text" name="title">
    <br>
    Tresc: <input type="text" name="content">
    <br>

    <input type="submit" value="Dodaj">
</form>
</body>
</html>
