<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 14.11.2020
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="book" method="post" action="/admin/books/addEdit">
    <form:hidden path="id"/>

    <form:label path="isbn">ISBN:</form:label>
    <form:input path="isbn"/>
    <form:errors path="isbn" cssClass="error"/><br>

    <form:label path="title">Tytuł:</form:label>
    <form:input path="title"/>
    <form:errors path="title" cssClass="error"/><br>

    <form:label path="author">Autor:</form:label>
    <form:input path="author"/>
    <form:errors path="author" cssClass="error"/><br>

    <form:label path="publisher">Wydawca:</form:label>
    <form:input path="publisher"/>
    <form:errors path="publisher" cssClass="error"/><br>

    <form:label path="type">Typ:</form:label>
    <form:input path="type"/>
    <form:errors path="type" cssClass="error"/><br>
    <button type="submit">Wyślij</button>
</form:form>
<a href="/admin/books/all">List</a>
</body>
</html>
