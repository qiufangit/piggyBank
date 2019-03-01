<%--
  Created by IntelliJ IDEA.
  User: homolo
  Date: 19-2-27
  Time: 下午3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/sign" method="post">
        帐号:<input name="username" type="text">
        密码:<input name="password" type="password">
        <br><input type="submit" value="注册">
    </form>
</body>
</html>
