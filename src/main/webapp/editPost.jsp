<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jazwa
  Date: 2019-03-24
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit post</title>
</head>
<body>
<article>
    <header>
        ${post.getTitle()}
        Created at: ${post.getCreatedAt()}
    </header>
</article>
<form action="/edit" method="post">

    Tresc: <input type="text" name="content">
    <br>

    <input type="submit" value="Zmien">
</form>
</body>
</html>
