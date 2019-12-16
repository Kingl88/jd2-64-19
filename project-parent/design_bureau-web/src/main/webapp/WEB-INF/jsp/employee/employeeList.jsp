<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="a" uri="/WEB-INF/taglib/auth.tld" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<%@include file="../include/menu.jsp" %>
<table>
    <tr>
        <td>Id</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Position in company</td>
        <td>Phone number</td>

    </tr>
    <jsp:useBean id="employeeList" scope="request" type="java.util.List"/>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td><c:out default="id" value="${employee.getId()}"/></td>
            <td><c:out value="${employee.getFirstName()}"/></td>
            <td><c:out value="${employee.getLastName()}"/></td>
            <td><c:out value="${employee.getPositionInCompany()}"/></td>
            <td><c:out value="${employee.getPhoneNumber()}"/></td>
            <th>
                <a:auth path="/del_employee">
                    <c:url value="/del_employee?id=${employee.getId()-1}" var="delete_link" scope="page"/>
                    <a href="${delete_link}">Delete</a>
                </a:auth>
            </th>
        </tr>
    </c:forEach>
</table>
<p>
    <c:url value="/employeeCreate" var="add" scope="page"/>
    <a href="${add}">Add new Employee</a>
</p>
<%@include file="../include/footer.jsp" %>
</body>
</html>
