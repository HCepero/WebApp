<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 11/5/2023
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>To-Do List</title>
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <h1>To-Do List</h1>
</header>

<div class="container">
    <ul class="todo-list">
        <c:forEach var="todo" items="${todos}">
            <li class="todo-item" id="item-${todo.id}">
                    ${todo.description}
                <!-- Add any buttons or actions for each to-do item here -->
            </li>
        </c:forEach>
    </ul>
</div>

<script src="<c:url value='/resources/js/scripts.js'/>"></script>
</body>
</html>
