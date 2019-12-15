<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Create drawing</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/drawingCreate">
    <label> Название чертежа <input type="text" name="name"/> </label>
    <br>
    <br>
    <label> Обозначение чертежа <input type="text" name="designation"/> </label>
    <br>
    <br>
    <label> Разработал
        <select name="developed">
        <c:forEach var="name" items="${names}">
            <option value="${name.lastName}">${name.firstName} ${name.lastName}</option>
        </c:forEach>
    </select>
    </label>
    <br>
    <br>
    <label> Проверил
        <select name="checked">
        <c:forEach var="name" items="${names}">
            <option value="${name.lastName}">${name.firstName} ${name.lastName}</option>
        </c:forEach>
    </select>
    </label>
    <br>
    <br>
    <label> Утвердил
        <select name="approved">
        <c:forEach var="name" items="${names}">
            <option value="${name.lastName}">${name.firstName} ${name.lastName}</option>
        </c:forEach>
    </select>
    </label>
    <br>
    <label>
        Является сборкой:<br />
        <input type="radio" name="isAssembly" value="true" checked="checked" /> true <br />
        <input type="radio" name="isAssembly" value="false" /> false <br />
    </label>
    <input type="submit">
</form>
</body>
</html>
