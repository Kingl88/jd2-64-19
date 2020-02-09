<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="my_menu">

    <a href="${pageContext.request.contextPath}/">Home</a>
    |
    <c:set var="user" value="${sessionScope.auth_user}"/>
    <c:choose>
        <c:when test="${user.role.equals('ADMIN')}">
            <a href="${pageContext.request.contextPath}/admin/employeeList">Employee List</a>
            |
            <a href="${pageContext.request.contextPath}/admin/drawingList">Drawing List</a>
            |
            <a href="${pageContext.request.contextPath}/admin/userInfo">My Account Info</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/user/employeeList">Employee List</a>
            |
            <a href="${pageContext.request.contextPath}/user/drawingList">Drawing List</a>
            |
            <a href="${pageContext.request.contextPath}/user/userInfo">My Account Info</a>
        </c:otherwise>
    </c:choose>
    |
    <a href="${pageContext.request.contextPath}/login">Login</a>

</div>