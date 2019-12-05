<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.12.2019
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<form method="post" action="${} /productCreate">
    <label> Name <input type="text" name="name"/> </label>
    <br>
    <label> Price: <input type="number" name="price"/> </label>
    <br>
    <input type="submit">
</form>
</body>
</html>
