<%@page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<fmt:message var="title" key="application.title" />

<u:html title="${title}">
	<div class="context">
		<div align="centr">
			<h2>
				<fmt:message key="index.welcomMessage" />
			</h2>
		</div>
	</div>
</u:html>