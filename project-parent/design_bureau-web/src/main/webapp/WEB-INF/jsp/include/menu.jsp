<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="padding: 5px;">

    <a href="${pageContext.request.contextPath}/">Home</a>
    |
    <c:set var="user" value="${sessionScope.auth_user}"/>
    <c:choose>
        <c:when test="${user.role.equals('ADMIN')}">
            <a href="${pageContext.request.contextPath}/admin/employeeList">Employee List</a>
        </c:when>
        <c:when test="${user.role.equals('USER')}">
            <a href="${pageContext.request.contextPath}/user/employeeList">Employee List</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/user/employeeList">Employee List</a>
        </c:otherwise>
    </c:choose>
    |
    <c:choose>
        <c:when test="${user.role.equals('ADMIN')}">
            <a href="${pageContext.request.contextPath}/admin/drawingList">Drawing List</a>
        </c:when>
        <c:when test="${user.role.equals('USER')}">
            <a href="${pageContext.request.contextPath}/user/drawingList">Drawing List</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/user/drawingList">Drawing List</a>
        </c:otherwise>
    </c:choose>
    |
    <c:choose>
        <c:when test="${user.role.equals('ADMIN')}">
            <a href="${pageContext.request.contextPath}/admin/userInfo">My Account Info</a>
        </c:when>
        <c:when test="${user.role.equals('USER')}">
            <a href="${pageContext.request.contextPath}/user/userInfo">My Account Info</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/user/userInfo">My Account Info</a>
        </c:otherwise>
    </c:choose>
    |
    <a href="${pageContext.request.contextPath}/login">Login</a>

</div>