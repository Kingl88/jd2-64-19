<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang = ${param.lang}>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<%@include file="include/header.jsp"%>
<%@include file="include/menu.jsp" %>

<h3>Login Page</h3>
<p style="color: red;">${errorString}</p>


<form method="POST" action="${pageContext.request.contextPath}/login">
    <table border="0">
        <tr>
            <td><fmt:message key="login.page.user.name"/></td>
            <td><input type="text" name="userName" value="${userName}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="login.page.user.password"/></td>
            <td><input type="password" name="password" value=""/></td>
        </tr>
        <tr>
            <td><fmt:message key="login.page.user.remember"/></td>
            <td><input type="checkbox" name="rememberMe" value="Y"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<fmt:message key="login.page.submit"/>"/>
                <a href="${pageContext.request.contextPath}/"><fmt:message key="login.page.cancel"/></a>
            </td>
        </tr>
    </table>
</form>

<p style="color:blue;">Admin User: IvanKb password: Ivan98</p>
<p style="color:blue;">Simple User: AlexKb password: Alex89</p>
<jsp:include page="include/footer.jsp"/>
</body>
</html>
