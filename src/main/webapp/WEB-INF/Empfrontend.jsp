<%--
  Created by IntelliJ IDEA.
  User: Talha
  Date: 22/09/2021
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <c:if test="${emp != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${emp == null}">
        <form action="insert" method="post">
            </c:if>
            <table style="" border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${emp != null}">
                            Update Employee
                        </c:if>
                        <c:if test="${emp == null}">
                            Add new Employee
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${emp != null}">
                    <input type="hidden" name="id" value="<c:out value='${emp.id}' />"/>
                </c:if>
                <tr>
                    <th>Title:</th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${emp.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="author" size="45"
                               value="<c:out value='${emp.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Profession:</th>
                    <td>
                        <input type="text" name="price" size="5"
                               value="<c:out value='${emp.profession}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>

</body>
</html>
