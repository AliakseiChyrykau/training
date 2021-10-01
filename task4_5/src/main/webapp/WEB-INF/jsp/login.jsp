<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:message var="title" key="application.title"/>
<u:html title="${title}">
    <div class="context">
	    <c:if test="${not empty param.message}">
	        <p class="error"><fmt:message key="${param.message}"/></p>
	    </c:if>
	    <c:url var="urlLogin" value="/login.html"/>
	    <c:url var="urlRegistration" value="/registration.html"/>
		<div align="center">    
		    <form action="${urlLogin}" method="post">
		        <p><label for="login"><fmt:message key="login.form.login"/>:</label></p>
		        <p><input id="login" name="login" required></p>
		        <p><label for="password"><fmt:message key="login.form.password"/>:</label></p>
		        <p><input id="password" name="password" type="password" required></p>
		        <p><button class="login"><fmt:message key="login.button.login"/></button></p>
		        <a class="registration" href="${urlRegistration}"><fmt:message key="login.button.registration"/></a>
		    </form>
		</div>
	</div>
</u:html>