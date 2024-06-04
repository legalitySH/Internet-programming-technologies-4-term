<%--
  Created by IntelliJ IDEA.
  User: rpshe
  Date: 26.04.2024
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>

  <form style="text-align: center" action="reg-servlet" method="post">
    <p>Логин: <input name="login" type="text" width="200px"></p>
    <p>Пароль: <input name="password" type="password" width="200px"></p>
    <p>
      <select id="role" name="role">
        <option value="admin">Администратор</option>
        <option value="user">Пользователь</option>
      </select>
    </p>
    <button type="submit">Регистрация</button>
  </form>

  <h4>${regMessage}</h4>

</head>
<body>

</body>
</html>
