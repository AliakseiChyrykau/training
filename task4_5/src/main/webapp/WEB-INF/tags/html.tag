<%@tag language="java" pageEncoding="UTF-8"%>

<%@attribute name="title" required="true" rtexprvalue="true"
	type="java.lang.String"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${title}</title>
		<c:url var="urlCss" value="/css/style.css" />
		<link href="${urlCss}" rel="stylesheet">
	</head>
	<body>
		<u:header title='${title}' />
			<c:if test="${not empty currentUser}">
				<div class="navigation">
					<div class="menuItem">
					
					</div>
				</div>
		    </c:if>
		<jsp:doBody />
	</body>
</html>