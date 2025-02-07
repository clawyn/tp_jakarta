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
        <a href="/pages/index.jsp"> Accueil</a>

        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </c:if>
    <c:if test="${currentUser == null}">
        <table>
            <thead>
            <tr>
                <th> Aimer son poney </th>
                <img src="img/poney.png" alt="poney" style="width: 400px; height: 300px;">
                <th> Caresser son poney </th>
                <img src="img/caresser.png" alt="poney qui se fait caresser" style="width: 400px; height: 300px;">
                <th> pommener son poney </th>
                <img src="img/prommenade.png" alt="poney qui se promene" style="width: 400px; height: 300px;">
            </tr>
            </thead>
        </table>
    </c:if>
    <c:if test="${currentUser != null && currentUser.accepted == true}">
        <img src="img/frison_ténébreux.png" alt="poney" style="width: 400px; height: 300px;">
        <a href="/pages/addWeapon.jsp"> Add weapon</a>

        <table>
            <thead>
            <tr>
                <th>Numéro de série </th>
                <th>Type</th>
                <th>Model</th>
                <th>History</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="weapon" items="${weapons}">
                <tr>
                    <td>${weapon.name}</td>
                    <td>
                        <c:if test="${weapon.type != null}">
                            ${weapon.type}
                        </c:if>
                        <c:if test="${weapon.type == null}">
                            Pas de type
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${weapon.model != null}">
                            ${weapon.model}
                        </c:if>
                        <c:if test="${weapon.model == null}">
                            Pas de model
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${weapon.history != null}">
                            ${weapon.history}
                        </c:if>
                        <c:if test="${weapon.history == null}">
                            Pas de histoir
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</main>
<c:if test="${currentUser == null || currentUser.accepted == false}">
    <%@include file="/layout/footer.jsp"%>
</c:if>
<c:if test="${currentUser != null && currentUser.accepted == true}">
    <%@include file="/layout/footer_2.jsp"%>
</c:if>

<!--/src/main/webApp/layout/footer.jsp-->
</html>