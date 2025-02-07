<%--
  Created by IntelliJ IDEA.
  User: DEV08
  Date: 07-02-25
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/update?id=${user.id}" method="post">
    <div>
        <label for="id">ID : </label>
        <input id="id" type="number" name="id" value="${user.id}">
    </div>
    <div>
        <label for="pseudonym">pseudonym : </label>
        <input id="pseudonym" type="text" name="pseudonym" value="${user.pseudonym}">
    </div>
    <div>
        <label for="role">role : </label>
        <input id="role" type="text" name="role" value="${user.role}">
    </div>
    <button type="submit">modifier</button>
</form>
</body>
</html>
