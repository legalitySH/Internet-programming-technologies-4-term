<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
    <form style="text-align: center" action="auth-servlet" method="post">
        <p>Логин: <input name="login" type="text" width="200px"></p>
        <p>Пароль: <input name="password" type="password" width="200px"></p>
        <button type="submit">Авторизация</button>
    </form>
    <a href="register.jsp"><button>Регистрация</button></a>
    <h4>${authMessage}</h4>
</body>
</html>
