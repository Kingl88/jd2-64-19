<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="/WEB-INF/taglib/auth.tld" %>
<html>
<head>
    <title>Drawing List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<jsp:include page="../include/header.jsp"/>
<%@include file="../include/menu.jsp" %>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Designation</td>
        <td>Developed</td>
        <td>Checked</td>
        <td>Approved</td>
        <td>isAssembly</td>

    </tr>
    <c:forEach items="${drawingList}" var="drawing">
        <tr>
            <td><c:out value="${drawing.id}"/></td>
            <td><c:out value="${drawing.name}"/></td>
            <td><c:out value="${drawing.designation}"/></td>
            <td><c:out value="${drawing.developed.getFirstName()}"/></td>
            <td><c:out value="${drawing.checked.getFirstName()}"/></td>
            <td><c:out value="${drawing.approved.getFirstName()}"/></td>
            <td><c:out value="${drawing.isAssembly()}"/></td>
            <th>
                <a:auth path="/del_drawing">
                    <a href="${delete_link}">Delete</a>
                </a:auth>
            </th>
        </tr>
    </c:forEach>
</table>
<p>
    <c:url value="/drawingCreate" var="add" scope="page"/>
    <a href="${add}">Add new Drawing</a>
</p>
<%@include file="../include/footer.jsp" %>
</body>
</html>
