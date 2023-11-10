<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 11/5/2023
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hibernate.ToDoItem" %>
<%@ page import="java.util.Optional" %>
<%
    // Assume that a ToDoItem with the given ID is fetched from the database
    // This is just placeholder code. You will need to replace it with actual logic.
    Optional<ToDoItem> todo = Optional.empty();
    String idParam = request.getParameter("id");
    if (idParam != null) {
        Long id = Long.parseLong(idParam);
        // todo = someMethodToFindToDoById(id);
    }

    ToDoItem todoItem = todo.orElse(new ToDoItem());
%>
<html>
<head>
    <title>Edit To-Do</title>
</head>
<body>
<h2>Edit To-Do</h2>
<form action="updateTodo" method="post">
    <input type="hidden" name="id" value="${todoItem.id}">
    Description: <input type="text" name="description" value="${todoItem.description}">
    Completed: <input type="checkbox" name="completed" ${todoItem.completed ? 'checked' : ''}>
    <input type="submit" value="Update">
</form>
<a href="list-todos">Back to List</a>
</body>
</html>
