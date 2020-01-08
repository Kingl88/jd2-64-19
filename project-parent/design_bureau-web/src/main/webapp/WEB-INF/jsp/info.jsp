<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="${param.lang}">
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<%@include file="include/menu.jsp" %>
<table>
    <label> Логин: <input type="text" name="login" value="<c:out value="${employee.getLogin()}"/>"/> </label>
    <br>
    <br>
    <label> Пароль: <input type="text" name="password"/> </label>
    <br>
    <br>
    <label> Имя: <input type="text" name="firstName" value="<c:out value="${employee.getFirstName()}"/>"/></label>
    <br>
    <br>
    <label> Фамилия: <input type="text" name="lastName" value="<c:out value="${employee.getLastName()}"/>"/> </label>
    <br>
    <br>
    <label> Должность: <input type="text" name="positionInCompany" value="<c:out value="${employee.getPositionInCompany()}"/>"/> </label>
    <br>
    <br>
    <label> Номер телефона: <input type="text" name="phoneNumber" value="<c:out value="${employee.getPhoneNumber()}"/>"/> </label>
    <br>
    <br>
    <input type="submit" value="Send">
    <br>
    </tr>
</table>
<%@include file="include/footer.jsp" %>
</body>
</html>
