<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/import/import.jsp" %>
    <!--/src/main/webApp/import/import.jsp-->
    <title> Connexion </title>
</head>
<%--<%@include file="/layout/header.jsp"%>--%>
<!--/src/main/webApp/layout/header.jsp-->
<body>
    <main>
        <form action="${pageContext.request.contextPath}/log" method="post">

            <div>
                <label for="pseudonym" >Pseudonym : </label>
                <input type="text" id="pseudonym" name="pseudonym">
            </div>
            <div>
                <label for="password"> Mot de passe : </label>
                <input type="password" id="password" name="password">
            </div>
            <button type="submit"> Log </button>
        </form>
    </main>
<%--<%@include file="/layout/footer.jsp"%>--%>
<!--/src/main/webApp/layout/footer.jsp-->
</body>
</html>