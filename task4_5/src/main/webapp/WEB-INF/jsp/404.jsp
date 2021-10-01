<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:message var="title" key="application.title" />
<u:html title="${title}">
	<div class="context">
		<div align="centr">
			<h1>
				<p>404</p>
				<p><fmt:message key="application.404"/></p>
			<h1>
		</div>
	</div>
</u:html>