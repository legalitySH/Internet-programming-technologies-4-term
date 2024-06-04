<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JSTL Functions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            padding: 20px;
        }
        .example {
            margin-bottom: 20px;
            padding: 10px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .example h3 {
            margin-top: 0;
        }
    </style>
</head>
<body>
<div class="example">
    <h3>Работа со строками</h3>
    <c:set var="fullName" value="Джон Смит Доу"/>
    <c:out value="Полное имя: ${fullName}"/>
    <br/><br/>
    <c:if test="${fn:startsWith(fullName, 'Джон')}">
        Имя начинается с 'Джон'
    </c:if>
    <br/>
    <c:if test="${fn:endsWith(fullName, 'Доу')}">
        Имя заканчивается на 'Доу'
    </c:if>
</div>

<div class="example">
    <h3>Работа с email и URL</h3>
    <c:set var="emailAddress" value="john.doe@example.com"/>
    Домен в email: ${fn:substringAfter(emailAddress, '@')}<br/>
    <c:set var="webLink" value="https://www.example.com/path/to/page.html"/>
    Путь URL: ${fn:substringBefore(webLink, '.html')}
</div>

<div class="example">
    <h3>Преобразование строк</h3>
    <c:set var="text" value="Это пример строки для демонстрации функций"/>
    Длина строки: ${fn:length(text)}<br/>
    Строка в верхнем регистре: ${fn:toUpperCase(text)}<br/>
    Строка в нижнем регистре: ${fn:toLowerCase(text)}<br/>
</div>

<div class="example">
    <h3>Разделение и объединение строк</h3>
    <c:set var="numbers" value="${fn:split('1,2,3,4,5', ',')}"/>
    Список чисел: <c:forEach var="num" items="${numbers}">${num} </c:forEach>
    <br/><br/>
    <c:set var="words" value="${fn:split('apple,banana,cherry,date', ',')}"/>
    Список слов: ${fn:join(words, '-')}<br/>
    <c:set var="reversedWords" value="${fn:split(fn:join(words, '-'), '-')}"/>
    <c:set var="reversedList" value="${fn:join(reversedWords, ',')}"/>
    Список слов в обратном порядке: ${reversedList}
</div>
</body>
</html>