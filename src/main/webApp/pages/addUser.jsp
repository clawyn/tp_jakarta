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
<%@include file="/layout/header_2.jsp"%>
<main>
   <h2> Formulaire nouveau user </h2>
    <div>
        <label for="FirstName">Prénom :</label>
        <input type="text" id="FirstName" name="FirstName" required><br>
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
    <div>
        <label for="accepted">accepted :</label>
        <input type="text" id="accepted" name="accepted" required><br>
        <button type="button" id="chooseAccepted"> A </button>
        <button type="button" id="chooseRejected"> R </button>
    </div>
    <div>
        <label for="role">role :</label>
        <input type="text" id="role" name="role" required><br>
    </div>
</main>
<%@include file="/layout/footer_2.jsp"%>
</body>
</html>
