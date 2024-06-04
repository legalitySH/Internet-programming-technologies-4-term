<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<%
  request.getRequestDispatcher("/lab_8_war_exploded/hello").forward(request, response);
%>
</body>
</html>