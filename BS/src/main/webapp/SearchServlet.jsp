<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作成功页面</title>
</head>
<body>
<h2>操作成功</h2>
<p>成功<%= request.getAttribute("username")%>！</p>
<a href="HelloServlet">返回HelloServlet</a>
</body>
</html>
