<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<div class="session">
  <form method="post" action="RegisterServlet" class="log-in" autocomplete="off">
    <h4>Регистрация</h4>
    <p>${ErrorMessage}</p>
    <div class="floating-label">
      <input placeholder="Логин" name="login" id="email" autocomplete="off">
      <label for="email">Логин</label>
    </div>
    <div class="floating-label">
      <input placeholder="Пароль" type="password" name="password" id="password" autocomplete="off">
      <label for="password">Пароль</label>
    </div>
    <button type="submit" >Зарегистрироваться</button>
    <a href="login.jsp" class="discrete" target="_self">Войти</a>
  </form>
</div>
</body>
</html>
