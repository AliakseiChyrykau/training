<%@tag language="java" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<%@attribute name="title" required="true" rtexprvalue="true"
	type="java.lang.String"%>

<header>
	<div class="header">
		<u:language />
		<div class="headerItem">
			<h2>${title}</h2>
		</div>
		<u:userData />
	</div>
</header>