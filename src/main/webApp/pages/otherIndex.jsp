<%--
  Created by IntelliJ IDEA.
  User: DEV08
  Date: 03-02-25
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <%@include file="/src/main/webApp/import/import.jsp"%>
  <title>Armes</title>
</head>
<%@include file="/src/main/webApp/layout/header_2.jsp"%>
<main>
  <c:if test="${currentUser == null}">
    <a href="/src/main/webApp/pages/addUser.jsp"> Add user </a>
    <a href="/src/main/webApp/pages/log.jsp" >log</a>
  </c:if>
  <c:if test="${currentUser != null && currentUser.accepted.equals(true)}">
    <a href="/accepted/weapon/create"> Créer </a>
  </c:if>
  <c:if test="${currentUser != null}">
    <form action="${pageContext.request.contextPath}/Logout" method="post">
      <button type="submit"> Logout</button>
    </form>
  </c:if>
  <table>
    <thead>
    <tr>
      <th>Numéro de série </th>
      <th>Type</th>
      <th>Model</th>
      <th>History</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="waepon" items="${weapons}">
      <tr>
        <td>${weapon.type}</td>
        <td>${weapon.model}</td>
        <td>
          <c:if test="${weapon.history != null}">
            ${weapon.history}
          </c:if>
          <c:if test="${weapon.history == null}">
            Pas d'histoire connue.
          </c:if>
        </td>
        <td>
          <button>
            <a href="/weaponhistory?id=${weapon.id}">Passif de l'arme</a>
          </button>
          <c:if test="${currentUser != null && currentUser.accepted.equals(true) && currentUser.role.equals('admin')}">
            <button>
              <a href="/admn/weapon/update?id=${weapon.id}">Update</a>
            </button>

          </c:if>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</main>
<%@include file="/src/main/webApp/layout/footer_2.jsp"%>
</html>