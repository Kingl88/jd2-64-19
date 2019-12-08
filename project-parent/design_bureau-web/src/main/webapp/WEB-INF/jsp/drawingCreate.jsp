<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create drawing</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/drawingCreate">
    <label> Название чертежа <input type="text" name="name"/> </label>
    <br>
    <br>
    <label> Обозначение чертежа <input type="text" name="designation"/> </label>
    <br>
    <br>
    <label> Разработал <input type="text" name="developed"/></label>
    <br>
    <br>
    <label> Проверил <input type="text" name="checked"/> </label>
    <br>
    <br>
    <label> Утвердил <input type="text" name="approved"/> </label>
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
