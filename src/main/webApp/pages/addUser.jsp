<%--
  Created by IntelliJ IDEA.
  User: DEV08
  Date: 03-02-25
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>créer un utilisateur</title>
    <%@ include file="/import/import.jsp" %>

</head>
<body>
<%--<%@include file="/layout/header_2.jsp"%>--%>
<main>
    <a href="/pages/index.jsp"> Accueil</a>
   <h2> Formulaire nouveau user </h2>
    <form action="${pageContext.request.contextPath}/addUser" method="post">
<%--        <div>--%>
<%--            <label for="id">id :</label>--%>
<%--            <input type="text" id="id" name="id" required><br>--%>
<%--        </div>--%>
        <div>
            <label for="firstName">Prénom :</label>
            <input type="text" id="firstName" name="firstName" required><br>
        </div>
        <div>
            <label for="lastName">Nom de famille :</label>
            <input type="text" id="lastName" name="lastName" required><br>
        </div>
        <div>
            <label for="pseudonym">pseudonym :</label>
            <input type="text" id="pseudonym" name="pseudonym" required><br>
        </div>
        <div>
            <label for="password">Mot de passe :</label>
            <input type="text" id="password" name="password" required><br>
        </div>
    <c:if test="${currentUser != null && currentUser.role.equals('admin')}">
        <a href="/pages/admin.jsp/">admin</a>
    </c:if>
        <c:if test="${currentUser != admin}">
            <div>
                <form action="${pageContext.request.contextPath}/rejected" method="post">
                    <label for="accepted">accepted :</label>
                    <input type="text" id="accepted" name="accepted" ><br>
                    <button type="button" id="chooseAccepted"> Accepted </button>
                    <button type="button" id="chooseRejected"> Rejected </button>
                </form>
            </div>
            <div>
                <label for="role">role :</label>
                <input type="text" id="role" name="role" required><br>
            </div>
        </c:if>
        <button type="submit"> Add</button>
    </form>
</main>
<%--<%@include file="/layout/footer_2.jsp"%>--%>
</body>
</html>
