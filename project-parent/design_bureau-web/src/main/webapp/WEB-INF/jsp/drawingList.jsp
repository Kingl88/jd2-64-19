<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Drawing List</title>
</head>
<body>

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
        </tr>
    </c:forEach>
</table>
</body>
</html>
