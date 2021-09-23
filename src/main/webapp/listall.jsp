<%@ page import="com.example.crudwithh2java.Emp" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Talha
  Date: 23/09/2021
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Employee MS</title>
</head>
<body>
<div style="text-align: center;">
  <h1>Employees</h1>
  <h2>
    <a href="/new">Add New Emp</a>
    &nbsp;&nbsp;&nbsp;
    <a href="/list">List All Emp</a>

  </h2>
</div>
<div >
  <table style="text-align: center;">
    <caption><h2>List of Books</h2></caption>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Profession</th>
      <th>Actions</th>
    </tr>
    <%
      ArrayList<Emp> arr = (ArrayList<Emp>) request.getAttribute("listUser");
      for(Emp emp: arr){%>
    <tr>
      <td><%=emp.getId()%></td>
      <td><%=emp.getName()%></td>
      <td><%=emp.getEmail()%></td>
      <td><%=emp.getProfession()%></td>
      <td><a href="edit?id=<c:out value='<%=emp.getId()%>' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="delete?id=<c:out value='<%=emp.getId()%>' />">Delete</a></td>

    <%--      <td>
        <a href="<%=request.getContextPath()%>/edit?id=<c:out value='${emp.id}' />">Update</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${emp.id}' />">Delete</a>
      </td>--%>
    </tr>
    <%}%>
  </table>
</div>
</body>
</html>