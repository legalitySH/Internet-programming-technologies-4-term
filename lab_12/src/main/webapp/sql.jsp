<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/tableStyle.css" />
    <title>Книжный каталог</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/users_db"
                   user="user" password="password" />

<sql:query dataSource="${snapshot}" var="users">
    SELECT * FROM users;
</sql:query>

<table>
    <tr>
        <th>ID</th>
        <th>Логин</th>
        <th>Роль</th>
    </tr>
    <c:forEach items="${users.rows}" var="us">
        <tr>
            <td><c:out value="${us.ID}" /></td>
            <td><c:out value="${us.login}" /></td>
            <td><c:out value="${us.role}" /></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>