<%@tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="headerItem">
	<c:url var="urlLanguage" value="/setLanguage.html" />
		<form action="${urlLanguage}" method="post">
			<p>
				<select name="language" size=1>
					<option value="ru">ru</option>
					<option value="en">en</option>
				</select>
			</p>
			<p>
				<button class="languageButton">
					<fmt:message key="application.button.language" />
				</button>
			</p>
		</form>
</div>