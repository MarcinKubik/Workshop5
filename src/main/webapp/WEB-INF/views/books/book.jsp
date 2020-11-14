<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 14.11.2020
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
    <p><c:out value="${book.isbn}"/></p>
    <p><c:out value="${book.title}"/></p>
    <p><c:out value="${book.author}"/></p>
    <p><c:out value="${book.publisher}"/></p>
    <p><c:out value="${book.type}"/></p>
    <a href="/admin/books/all">List</a>
</body>
</html>
