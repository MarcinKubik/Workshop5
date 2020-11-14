<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 14.11.2020
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<table border="1">
    <thead>
    <th>id</th>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>publisher</th>
    <th>type</th>
    <th>Edition</th>
    <th>Delete</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td><a href="/admin/books/edit/${book.id}">Edit</a></td>
            <td><a href="/admin/books/delete/${book.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/admin/books/add">Add book</a>
</body>
</html>
