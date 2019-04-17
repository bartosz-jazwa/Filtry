<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
</head>
<body>
<ul id="navbar">
    <li><a href="/dashboard">Dashboard</a></li>
    <li><a href="/addPost.jsp">Dodaj post</a></li>
</ul>

<section>
    <header>Blog posts</header>
    <c:forEach var="post" items="${posts}">
        <article>
            <header>
                ${post.getTitle()}
                Created at: ${post.getCreatedAt()}
            </header>
            <p>
                ${post.getContent()}
            </p>
            <p>
                <a href="/remove?id=${post.getId()}">Usun</a>
                <a href="/edit?id=${post.getId()}">Edytuj</a>
            </p>


        </article>
    </c:forEach>

</section>
</body>
</html>