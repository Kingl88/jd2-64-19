<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>

<table>
    <tr>
        <td>Id</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Position in company</td>
        <td>Phone number</td>

    </tr>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td><c:out value="${employee.getId()}"/></td>
            <td><c:out value="${employee.getFirstName()}"/></td>
            <td><c:out value="${employee.getLastName()}"/></td>
            <td><c:out value="${employee.getPositionInCompany()}"/></td>
            <td><c:out value="${employee.getPhoneNumber()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
