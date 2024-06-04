<%@ page import="by.belstu.Lab10.classes.DAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="by.belstu.Lab10.classes.UniversityClass" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Admin page</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container" style="margin-top: 200px">
  <div id="tableDiv">
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Учреждение</th>
        <th>Количество игроков</th>
      </tr>
      </thead>

      <tbody>
      <%
        try {
          DAO db = new DAO();
          db.getConnection();
          ArrayList<UniversityClass> classes = new ArrayList<>(db.getClasses());
          for (UniversityClass uc : classes) {
      %>
      <tr>
        <td><%=uc.getClassId()%></td>
        <td><%=uc.getClassName()%></td>
        <td><%=uc.getClassDay()%></td>
        <td><%=uc.getClassHours()%></td>
      </tr>
      <%
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      %>
      </tbody>
    </table>
  </div>


  <div id="add-remove-div">
    <form id="add-form" method="post" action="MainServlet">
      <h3 style="font-weight: bold">Добавить команду</h3>
      <input type="text" placeholder="Название" name="name" autocomplete="off"/>
      <input type="text" placeholder="Учреждение" name="institution" autocomplete="off"/>
      <input type="text" placeholder="Количество игроков" name="quantity" autocomplete="off"/>
      <button type="submit">Добавить</button>
    </form>
    <br/><br/>
    <form id="edit-form" method="post" action="MainServlet">
      <h3 style="font-weight: bold">Изменить данные команды</h3>
      <input type="hidden" name="action" value="edit" />
      <input type="text" placeholder="ID" name="idEdit" autocomplete="off" />
      <input type="text" placeholder="Новое название" name="nameEdit" autocomplete="off" />
      <input type="text" placeholder="Новое учреждение" name="institutionEdit" autocomplete="off" />
      <input type="text" placeholder="Новое количество" name="quantityEdit" autocomplete="off" />
      <button type="submit">Изменить</button>
    </form>
    <br/><br/>
    <form id="remove-form" method="get" action="MainServlet">
      <h3 style="font-weight: bold">Удалить команду</h3>
      <input type="text" placeholder="ID" name="id" autocomplete="off"/>
      <button type="submit">Удалить</button>
    </form>


  </div>

</div>


<jsp:include page="footer.jsp"/>

</body>
</html>