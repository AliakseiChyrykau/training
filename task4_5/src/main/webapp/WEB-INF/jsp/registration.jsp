<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:message var="title" key="application.title"/>
<u:html title="${title}">
    <div class="context">
	    <c:url var="urlregistrationPerform" value="/registrationPerform.html"/>
		<div align="center">    
		    <form action="${urlregistrationPerform}" method="post">
		        <p><label for="login"><fmt:message key="login.form.login"/>:</label></p>
		        <p><input class="login" name="login" required></p>
		        
		        <p><label for="password"><fmt:message key="login.form.password"/>:</label></p>
		        <p><input class="password" name="password" type="password" required></p>
		        
		        <p><label for="name"><fmt:message key="registration.form.name"/>:</label></p>
		        <p><input class="name" name="name" required></p>
		        
		        <p><label for="lastName"><fmt:message key="registration.form.lastName"/>:</label></p>
		        <p><input class="lastName" name="lastName"></p>
		        
		        <p><button class="registrationPerform"><fmt:message key="registration.button.registrationPerform"/></button></p>
		    </form>
		</div>
	</div>
</u:html>