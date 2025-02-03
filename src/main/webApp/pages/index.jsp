<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/src/main/webApp/import/import.jsp"%>
    <title>Poney</title>
</head>
<%@include file="/src/main/webApp/layout/header.jsp"%>
<main>
    <c:if test="${currentUser == null}">
        <a href="/src/main/webApp/pages/addUser.jsp"> Add user </a>
        <a href="/src/main/webApp/pages/log.jsp" >log</a>
    </c:if>
    <c:if test="${currentUser != null && currentUser.accepted.equals(true)}">
        <a href="/src/main/webApp/pages/otherIndex.jsp"> Over </a>
    </c:if>
    <c:if test="${currentUser != null}">
        <form action="${pageContext.request.contextPath}/Logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </c:if>
    <table>
        <thead>
        <tr>
            <th> Aimer son poney</th>
            <th> Caresser son poney</th>
            <th> pommener son poney </th>
        </tr>
        </thead>
    </table>
</main>
<%@include file="/src/main/webApp/layout/footer.jsp"%>
</html>