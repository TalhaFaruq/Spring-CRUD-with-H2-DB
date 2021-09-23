<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Talha
  Date: 23/09/2021
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <form action="update" method="post">
        <p>Id <input type="text" id="id" name="id"  value = "<c:out value='${existingemp.id}' />" ></p>
        <p> Name <input type="text" id="name" name="name"   value = "<c:out value='${existingemp.name}' />"><br><br></p>
        <p> Email <input type="text" id="email" name="email  value = "<c:out value='${existingemp.email}' />"> </p>
        <p>Profession <input type="text" id="profession" name="profession" value = "<c:out value='${existingemp.profession}' />" ></p>
        <p> <input type="submit" value="Submit"></p>
    </form>
</div>
</body>
</html>