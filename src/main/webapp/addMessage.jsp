<%--
  Created by IntelliJ IDEA.
  User: KaWa
  Date: 14.07.2018
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Message @SDA Twitter</title>
</head>
<body>
<form method="post" action="/addMessageServlet">
    <div style="text-align: right; width: 100%">
        <a href="index.jsp">Return to main page</a>
    </div>
    <textarea name="message"></textarea>
    <input type="submit" value="Submit">
</form>
</body>
</html>
