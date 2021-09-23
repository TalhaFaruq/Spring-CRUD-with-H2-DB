<%--
  Created by IntelliJ IDEA.
  User: Talha
  Date: 22/09/2021
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Employees Management System</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Employee Management</h1>
    <h2>
        <a href="/new">Add New Employee</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Emloyees</a>

    </h2>
</div>
<div style="text-align: center;">
    <form action="insert" method="post">
    <p> Name <input type="text" id="name" name="name"><br><br></p>
    <p> Email <input type="text" id="email" name="email"></p>
    <p>Profession <input type="text" id="profession" name="profession"></p>
    <p> <input type="submit" value="Submit"></p>
    </form>
    </div>
    </body>
    </html>