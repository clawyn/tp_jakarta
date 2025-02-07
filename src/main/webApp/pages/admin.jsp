<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="/import/import.jsp" %>
    <title>admin</title>
</head>
    <%@include file="/layout/header_2.jsp" %>
<main>

    <a href="/pages/addUser.jsp"> Add user </a>
    <a href="/pages/log.jsp">log</a>

    <a href="/pages/index.jsp"> Accueil</a>
    <form action="${pageContext.request.contextPath}/rejected" method="post">
        <a href="/pages/addUser.jsp"> Add User</a>

        <img src="img/dylan.png" alt="homme disant bonsoir" style="width: 400px; height: 300px;">
        <a href="/pages/addWeapon.jsp"> Add weapon</a>


            <c:if test="${currentUser != null && currentUser.role.equals('admin')}">
                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Pseudonym</th>
                        <th>role</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.pseudonym}</td>
                            <td>${user.role}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
    </form>


</main>

<%@include file="/layout/footer_2.jsp" %>


</html>