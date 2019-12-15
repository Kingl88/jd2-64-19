<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<fmt:setLocale scope="session" value="${param.lang}"/>
<fmt:setBundle basename="messages"/>
<div style="background: #E0E0E0; text-align: center; padding: 5px; margin-top: 10px;">
    <ul>
        <fmt:message key="footer.page.localization"/>
        <a href="?lang=en">en</a> |
        <a href="?lang=ru">ru</a>
    </ul>
    @Copyright Design_bureau 2019

</div>