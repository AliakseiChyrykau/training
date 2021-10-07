<%@page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<fmt:message var="title" key="application.title" />

<u:html title="${title}">
	<div class="context">
		<c:url var="createTTForm" value="/createTT.html"/>
		<div align="center">    
		    <form action="${createTTForm}" method="post">
		        <p><label for="Date"><fmt:message key="ttForm.date"/>:</label></p>
		        <p><input class="Date" name="Date" type="date" required></p>
		        
		        <p>
				    <select name="language" size=1>
					    <option value="1"><fmt:message key="ttForm.junior"/></option>
					    <option value="2"><fmt:message key="ttForm.middle"/></option>
					    <option value="3"><fmt:message key="ttForm.senior"/></option>
				    </select>
			    </p>
		        
		        <p><label for="nember_dev"><fmt:message key="ttForm.number_dev"/>:</label></p>
		        <p><input class="nember_dev" name="nember_dev" type="number" required></p>
		        
		        <p><button class="createTTForm"><fmt:message key="ttForm.button"/></button></p>
		    </form>
		</div>
	</div>
</u:html>