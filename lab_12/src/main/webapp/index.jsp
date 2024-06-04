<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Tag Examples</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #333333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background: #ffafff;
            padding: 2rem;
            border-radius: 8px;
            border: 1px solid white;
            box-shadow: 0 4px 8px rgba(0,2,0,0.2);
        }
        .container h1 {
            color: black;
        }
        .nav-links {
            list-style-type: none;
            padding: 0;
        }
        .nav-links li {
            margin: 1rem 0;
        }
        .nav-links a {
            text-decoration: none;
            color: cornflowerblue;
            font-size: 1.2rem;
            transition: color 0.3s ease;
        }
        .nav-links a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>JSTL Tag Examples</h1>
    <ul class="nav-links">
        <li><a href="core.jsp">Core tags</a></li>
        <li><a href="formatting.jsp">Formatting tags</a></li>
        <li><a href="sql.jsp">SQL tags</a></li>
        <li><a href="xml.jsp">XML tags</a></li>
        <li><a href="jstlFunctions.jsp">JSTL Functions</a></li>
        <li><a href="customTags.jsp">Custom tags</a></li>
    </ul>
</div>
</body>
</html>
