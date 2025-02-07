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
  <%@include file="/import/import.jsp"%>
  <!--/src/main/webApp/import/import.jsp-->
  <title>Armes</title>
</head>
<%--<%@include file="/layout/header_2.jsp"%>--%>
<!--/src/main/webApp/layout/header_2.jsp-->
<main>
  <c:if test="${currentUser == null}">
    <a href="/pages/addUser.jsp"> Add user </a>
    <a href="/pages/log.jsp" >log</a>
    <a href="/pages/addWeapon.jsp"> Add Weapon</a>
    <a href="/pages/index.jsp"> Accueil</a>
  </c:if>
<%--  <c:if test="${currentUser != null && currentUser.accepted.equals(true) && currentUser.role.equals('admin')}">--%>
<%--    <a href="/admin/weapon/create"> Créer </a>--%>
<%--  </c:if>--%>
  <c:if test="${currentUser != null}">
    <form action="${pageContext.request.contextPath}/logout" method="post">
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
        <td>${weapon.name}</td>
        <td>
            <c:if test="${weapon.type != null}">
              ${waepon.type}
            </c:if>
            <c:if test="${weapon.type == null}">
              Type inconnu.
            </c:if>
        </td>
        <td>
            <c:if test="${weapon.model}">
              ${weapon.model}
            </c:if>
            <c:if test="${weapon.model}">
              Model inconnu.
            </c:if>
        </td>
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
            <a href="/weapon/history?id=${weapon.serialNumber}">Passif de l'arme</a>
          </button>
          <c:if test="${currentUser != null && currentUser.accepted.equals(true) && currentUser.role.equals('admin')}">
            <button>
              <a href="/admn/weapon/update?id=${weapon.serialNumber}">Update</a>
            </button>

          </c:if>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</main>
<%--<%@include file="/layout/footer_2.jsp"%>--%>
<!--src/main/webApp/layout/footer_2.jsp-->
</html>