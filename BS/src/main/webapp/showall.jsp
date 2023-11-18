<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cesi.util.DB" %>
<%@ page import="cesi.model.User" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>所有用户</title>
</head>
<body>

<h2>所有用户</h2>
<table border="1">
    <tr>
        <th>姓名</th>
        <th>地址</th>
        <th>电话</th>
    </tr>
    <c:forEach items="${userList}" var="user" >
        <tr>
            <td>${user.name}</td>
            <td>${user.address}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="Register.jsp">增加用户</a>
<br>
<a href="Delete.jsp">删除用户</a>
<br>
<a href="Update.jsp">更新用户</a>
<br>
</body>
</html>
