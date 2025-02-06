<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/import/import.jsp"%>
    <!--/src/main/webApp/import/import.jsp-->
    <title>Poney</title>
</head>
<%@include file="/layout/header.jsp"%>
<!--/src/main/webApp/layout/header.jsp-->
<main>
    <c:if test="${currentUser == null}">
        <a href="/pages/addUser.jsp"> Add user </a>
        <!--/src/main/webApp/pages/addUser.jsp-->
        <a href="/pages/log.jsp" >log</a>
        <!--/src/main/webApp/pages/log.jsp-->

    </c:if>
    <c:if test="${currentUser == null}">
<%--        currentUser != null && (currentUser.accepted.equals(true) || currentUser.getRole().equals('ADMIN'))--%>
        <a href="/pages/otherIndex.jsp"> Over </a>
        <!--/src/main/webApp/pages/otherIndex.jsp-->
    </c:if>
    <c:if test="${currentUser != null}">
        <form action="${pageContext.request.contextPath}/logout" method="post">
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
<%@include file="/layout/footer.jsp"%>
<!--/src/main/webApp/layout/footer.jsp-->
</html>