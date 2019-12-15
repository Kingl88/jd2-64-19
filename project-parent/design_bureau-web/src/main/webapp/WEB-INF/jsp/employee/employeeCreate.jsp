<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Create drawing</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/employeeCreate">
    <label> Логин: <input type="text" name="login"/> </label>
    <br>
    <br>
    <label> Пароль: <input type="text" name="password"/> </label>
    <br>
    <br>
    <label> Имя: <input type="text" name="firstName"/></label>
    <br>
    <br>
    <label> Фамилия: <input type="text" name="lastName"/> </label>
    <br>
    <br>
    <label> Должность: <input type="text" name="positionInCompany"/> </label>
    <br>
    <br>
    <label> Номер телефона: <input type="text" name="phoneNumber"/> </label>
    <br>
    <input type="submit">
</form>
</body>
</html>