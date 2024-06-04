 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Демонстрация JSTL Core</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        h2 {
            color: #333;
        }
        pre {
            background-color: #eee;
            padding: 10px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<h2>Демонстрация JSTL core</h2>

<h3>Вывод и арифметические операции</h3>
<pre>
    <c:out value="10 + 5 = "/><c:out value="${10 + 5}"/>
    <c:out value="15 * 3 = "/><c:out value="${15 * 3}"/>
    </pre>

<h3>Условный вывод</h3>
<c:set var="age" value="25"/>
<c:choose>
    <c:when test="${age < 18}">
        <p>Вы несовершеннолетний.</p>
    </c:when>
    <c:when test="${age >= 18 && age < 65}">
        <p>Вы взрослый.</p>
    </c:when>
    <c:otherwise>
        <p>Вы пенсионер.</p>
    </c:otherwise>
</c:choose>

<h3>Итерация</h3>
<ul>
    <c:forEach var="i" begin="1" end="5">
        <li>Элемент <c:out value="${i}"/></li>
    </c:forEach>
</ul>

<h3>Перезапись URL-адресов</h3>
<a href="<c:url value="index.jsp"/>">Главная страница</a>

<h3>Обработка исключений</h3>
<c:catch var="exception">
    <% int x = 10 / 0; %>
</c:catch>
<c:if test="${exception != null}">
    <p>Произошло исключение: ${exception.message}</p>
</c:if>
</body>
</html>