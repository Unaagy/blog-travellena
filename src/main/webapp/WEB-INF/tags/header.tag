<%@tag description="Header page block with Add button and Search" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<header>

	<!-- Main Logo -->
	<p align="center">
		<img alt="main logo" src="${pageContext.request.contextPath}/resources/img/app-logo.png" align="middle">
	</p>

	<!--  Security content -->
	<security:authorize access="hasRole('ADMIN')">

		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			
			User: <security:authentication property="principal.username" />
			, has role(s): <security:authentication property="principal.authorities" />

			<input type="submit" value="Logout">
		</form:form>

		<!-- Add new Article buttonn -->
		<input align="center" type="button" value="Add Article" onclick="window.location.href='showFormForAdd'; return false;" />

	</security:authorize>
	<!--  /Security content -->

	<!-- Show menu block -->
	<t:menu />

	<!-- Search box -->
	<div align="center">
		<!-- Add a search box -->
		<form:form action="searchArticle" method="GET">

			<input type="text" name="searchString" />

			<input type="submit" value="Поиск по слову">
		</form:form>
	</div>

</header>