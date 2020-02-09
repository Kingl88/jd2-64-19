<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang= ${param.lang}>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<%@include file="include/header.jsp" %>
<%@include file="include/menu.jsp" %>

<h1>Login Page</h1>
<div class="frame">
    <p style="color: red;">${errorString}</p>

    <form style="padding: 1px 5px;" method="POST" action="${pageContext.request.contextPath}/login">

        <p><fmt:message key="login.page.user.name"/></p>
        <label>
            <input type="text" name="userName" value="${userName}" size="15"/>
        </label>
        <p><fmt:message key="login.page.user.password"/></p>
        <label>
            <input type="password" name="password" value="" size="15"/>
        </label>
        <table>
            <tr>
                <td><fmt:message key="login.page.user.remember"/></td>
                <td><label>
                    <input type="checkbox" name="rememberMe" value="Y"/>
                </label></td>
            </tr>
            <tr>
                <td>
                    <button style="font-size: 18px" type="submit" class="button1"><fmt:message
                            key="login.page.submit"/></button>
                </td>
                <td>
                    <button style="font-size: 18px" type="reset" class="button1"><fmt:message
                            key="login.page.cancel"/></button>
                </td>
            </tr>
        </table>
    </form>
</div>
<p style="color:blue;">Admin User: Ivan88 password: pass</p>
<p style="color:blue;">Simple User: Pety90 password: pass1</p>
<jsp:include page="include/footer.jsp"/>
</body>
</html>
