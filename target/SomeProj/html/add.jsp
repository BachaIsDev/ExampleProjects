<%--
  Created by IntelliJ IDEA.
  User: bacha
  Date: 13.03.2022
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<form action="add" method="post">
    <label>Name:
        <input type="text" name="name">
    </label>
    <label>Cost:
        <input type="text" name="cost">
    </label>
    <button type="submit">Send</button>
</form>
</body>
</html>
