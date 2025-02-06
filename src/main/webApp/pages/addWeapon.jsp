<%--
  Created by IntelliJ IDEA.
  User: DEV08
  Date: 04-02-25
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>créer une arme</title>
  <%@ include file="/import/import.jsp" %>

</head>
<body>
<%--<%@include file="/layout/header_2.jsp"%>--%>
<main>
  <form action="${pageContext.request.cntexPath}/weaponadd" method="post">
    <h2> Formulaire nouvelle arme </h2>
    <div>
      <label for="name">nom :</label>
      <input type="text" id="name" name="name" required><br>
    </div>
    <div>
      <label for="type">type :</label>
      <input type="text" id="type" name="type" required><br>
    </div>
    <div>
      <label for="model">model :</label>
      <input type="text" id="model" name="model" required><br>
    </div>
    <div>
      <label for="history">Histoir :</label>
      <input type="text" id="history" name="history" ><br>
    </div>
    <button type="submit"></button>
  </form>

</main>
<%--<%@include file="/layout/footer_2.jsp"%>--%>
</body>
</html>
