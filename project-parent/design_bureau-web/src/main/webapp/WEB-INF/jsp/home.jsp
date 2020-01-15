<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="include/header.jsp" %>
    <title><fmt:message key="home.page.header"/></title>
</head>
<body>



<%@include file="include/menu.jsp" %>

<h3><fmt:message key="home.page.header"/></h3>

<fmt:message key="home.page.text"/>

<ul>
    <li><fmt:message key="home.page.text.function.one"/></li>
    <li><fmt:message key="home.page.text.function.two"/></li>
    <li><fmt:message key="home.page.text.function.three"/></li>
    <li><fmt:message key="home.page.text.function.four"/></li>
</ul>

<jsp:include page="include/footer.jsp"/>

</body>
</html>
