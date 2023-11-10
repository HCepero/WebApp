<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 11/5/2023
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add To-Do</title>
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <h1>Add New To-Do</h1>
</header>

<div class="container">
    <form id="todo-form" action="addTodo" method="post">
        Description: <input type="text" name="description">
        <input type="submit" value="Add">
    </form>
</div>

<script src="<c:url value='/resources/js/scripts.js'/>"></script>
</body>
</html>
