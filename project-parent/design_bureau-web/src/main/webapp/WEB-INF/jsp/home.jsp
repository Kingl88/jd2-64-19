<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<%@include file="include/header.jsp" %>
<head>
    <title><fmt:message key="home.page.header"/></title>
</head>
<body>

<%@include file="include/menu.jsp" %>
<div class="content">

<h1><fmt:message key="home.page.header"/></h1>
<p>
    <fmt:message key="home.page.text"/>
</p>
<ol>
    <li><fmt:message key="home.page.text.function.one"/></li>
    <li><fmt:message key="home.page.text.function.two"/></li>
    <li><fmt:message key="home.page.text.function.three"/></li>
    <li><fmt:message key="home.page.text.function.four"/></li>
</ol>
</div>
</body>
<jsp:include page="include/footer.jsp"/>
</html>
