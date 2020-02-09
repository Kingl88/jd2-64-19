<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${param.lang != null}">
    <% session.setAttribute("design_bureau_locale", request.getParameter("lang")); %>
</c:if>

<c:if test="${sessionScope.design_bureau_locale != null}">
    <fmt:setLocale value="${sessionScope.design_bureau_locale}"/>
</c:if>

<fmt:setBundle basename="messages"/>

    <div style="padding: 15px; text-align: right; font-size: 14px;">
        <h2 class="header"><fmt:message key="header.app.title"/></h2>
        <c:if test="${sessionScope.auth_user != null}"> Hello <b>${sessionScope.auth_user.userNameLogin}</b>
            <a href="${pageContext.request.contextPath}/logout">logout</a>
        </c:if>
    </div>