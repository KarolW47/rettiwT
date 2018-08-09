<%--
  Created by IntelliJ IDEA.
  User: KaWa
  Date: 14.07.2018
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register @SDA Twitter</title>
</head>
<body>
<form method="post" action="registerServlet">
    <div style="text-align: right; width: 100%">
        <a href="index.jsp">Return to main page</a>
    </div>
    <label>Nick: </label><input type="text" name="nick" required="required"><br>
    <label>Email: </label><input type="email" name="email" required="required"><br>
    <label>Password: </label><input type="password" name="pass" required="required"><br>
    <input type="submit" name="submit" value="Submit">
</form>
</body>
</html>
