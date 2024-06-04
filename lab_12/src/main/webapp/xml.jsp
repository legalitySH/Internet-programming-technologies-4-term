<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
  <title>Демонстрация JSTL XML</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f8f8f8;
      padding: 20px;
    }
    h2 {
      color: #333;
    }
    table {
      border-collapse: collapse;
      width: 100%;
    }
    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }
    th {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<h2>Демонстрация JSTL XML</h2>

<c:import var="usersInfo" url="users.xml" charEncoding="UTF-8"/>
<c:if test="${not empty usersInfo}">
  <x:parse xml="${usersInfo}" var="output"/>

  <table>
    <tr>
      <th>Login</th>
      <th>Role</th>
    </tr>
    <x:forEach select="$output/users/user" var="book">
      <tr>
        <td><x:out select="$user/login"/></td>
        <td><x:out select="$user/role"/></td>
      </tr>
    </x:forEach>
  </table>
</c:if>
</body>
</html>