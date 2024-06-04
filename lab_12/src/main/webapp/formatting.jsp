<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Форматирование с JSTL</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            padding: 20px;
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
<h2>Форматирование с JSTL</h2>

<h3>Форматирование чисел</h3>
<c:set var="number" value="1234.567"/>
<pre>
    Исходное число: <c:out value="${number}"/>
    Форматирование с точностью 2:
    <fmt:formatNumber value="${number}" maxFractionDigits="2"/>
    Процентное значение:
    <fmt:formatNumber value="${number/1000}" type="percent"/>
    Формат валюты (по умолчанию):
    <fmt:formatNumber value="${number}" type="currency"/>
    Формат валюты (российский рубль):
    <fmt:setLocale value="ru-RU"/>
    <fmt:formatNumber value="${number}" type="currency"/>
    </pre>

<h3>Форматирование даты и времени</h3>
<jsp:useBean id="now" class="java.util.Date" />
<pre>
    Текущая дата и время:
    <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
    Только время (короткий формат):
    <fmt:formatDate value="${now}" type="time" timeStyle="short"/>
    Только дата (средний формат):
    <fmt:formatDate value="${now}" type="date" dateStyle="medium"/>
    </pre>

<h3>Парсинг дат</h3>
<c:set var="dateString" value="01.01.2023"/>
<fmt:parseDate value="${dateString}" var="parsedDate" pattern="dd.MM.yyyy"/>
<pre>
    Исходная строка даты: ${dateString}
    Спарсенная дата: <fmt:formatDate value="${parsedDate}" dateStyle="full"/>
    </pre>
</body>
</html>