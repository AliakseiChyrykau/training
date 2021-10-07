<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
    <div>
        <c:url var="urltoTTForm" value="/toTTForm.html" />
        <a href="${urltoTTForm}"><fmt:message key="customer.MenuItemCreateTT"/></a>
    </div>
</div>