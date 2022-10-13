<%--
  Created by IntelliJ IDEA.
  User: bacha
  Date: 19.03.2022
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:forEach var="products" items="${products}">
        <tr>
            <td><c:out value="${products.id}"></c:out> </td>
            <td><c:out value="${products.name}"></c:out> </td>
            <td><c:out value="${products.cost}"></c:out> </td>
        </tr>

        <br>
    </c:forEach>
</body>
</html>
