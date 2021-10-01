<%@tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<userData>
	<div class="headerItem">
		<c:if test="${not empty currentUser}">
			<c:url var="urlLogout" value="/logout.html" />
			<p>
				<fmt:message key="application.welcome" />
				${currentUser.login} (
				<fmt:message key="${currentUser.role.name}" />
				). <a href="${urlLogout}"><fmt:message
						key="application.button.logout" /></a>
			</p>
		</c:if>
	</div>
</userData>