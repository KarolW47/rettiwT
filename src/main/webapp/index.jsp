<%@ page import="com.sda.rettiwt.hibernate.dao.MessageDao" %>
<%@ page import="com.sda.rettiwt.hibernate.dao.UserDao" %>
<%@ page import="com.sda.rettiwt.hibernate.entity.Message" %>
<%@ page import="com.sda.rettiwt.hibernate.entity.User" %>
<%@ page import="com.sda.rettiwt.utils.Utils" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html;" %>
<html>
<head>
    <title>SDA Twitter</title>
</head>
<%

    List<User> userList = UserDao.getInstance().getAll().get();
    request.setAttribute("userList", userList);

    List<Message> messageList = MessageDao.getInstance().getAll().get();
    request.setAttribute("messageList", messageList);

    Optional<User> userFromCookies = Utils.getUserFromCookies(request);
    request.setAttribute("userLogged", userFromCookies);

    if (userFromCookies.isPresent()) {
        request.setAttribute("userNick", userFromCookies.get().getNick());
    }

%>
<jsp:useBean id="dateValue" class="java.util.Date"/>

<body bgcolor=#b0c4de>
<div style="text-align: right; width: 100%">
    <c:if test="${userLogged.present}">
        <a href="addMessage.jsp">Add message</a> / <a href="/logoutServlet">Logout</a>
    </c:if>
    <c:if test="${!userLogged.present}">
        <a href="login.jsp">Login</a> / <a href="register.jsp">Register</a>
    </c:if>
</div>

<div align="center">
    <h2 style="color: dodgerblue">Posted Messages:</h2>
    <div>
        <c:forEach var="message" items="${messageList}">
            <table border="2" bgcolor="white">
                <tr>
                    <td colspan="3">
                        <b>Content: </b> <c:out value="${message.content}"/>
                    </td>

                </tr>
                <tr>
                    <td>
                        <b>User: </b><c:out value="${message.user.nick}"/><br>
                    </td>
                    <td>
                        <c:set target="${dateValue}" property="time" value="${message.timestamp}"/>
                        <b>Time&Date: </b> <fmt:formatDate value="${dateValue}" pattern="dd/MM/yyyy HH:mm"/>
                    </td>

                    <c:choose>
                        <c:when test="${userNick eq message.user.nick}">
                            <td>
                                <a href="/editMessageServlet">Edit</a> / <a href="/deleteMessageServlet">Delete</a>
                            </td>
                        </c:when>

                        <c:when test="${userLogged.present}">
                            <td>
                                <a href="">Report</a>
                            </td>
                        </c:when>

                        <c:otherwise>
                            <td>
                                Log in for more options.
                            </td>
                        </c:otherwise>
                    </c:choose>

                </tr>

            </table>
        </c:forEach>

    </div>
</div>
</body>
</html>
