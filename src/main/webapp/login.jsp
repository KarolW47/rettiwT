<%--
  Created by IntelliJ IDEA.
  User: KaWa
  Date: 14.07.2018
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login @SDA Twitter</title>
</head>

<%
    if (null != request.getAttribute("errorMessage")) {
        System.out.println(request.getAttribute("errorMessage"));
    }
%>

<body>
<form method="post" action="loginServlet">
    <div style="text-align: right; width: 100%">
        <a href="index.jsp">Return to main page</a>
    </div>
    <label>Nick: </label><input type="text" name="nick"><br>
    <label>Password: </label><input type="password" name="pass"><br>
    <input type="submit" name="Login" value="Submit">
    <div style="color:red">
        <c:if test="${not empty errorMessage}">
            <c:out value="${errorMessage}"/>
        </c:if>
    </div>

</form>
</body>
</html>
