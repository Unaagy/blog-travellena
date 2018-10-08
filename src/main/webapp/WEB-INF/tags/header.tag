<%@tag description="Header page block with Add button and Search" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<header>

	<p align="center">
		<img alt="main logo" src="${pageContext.request.contextPath}/resources/img/app-logo.png" align="middle">
	</p>

	<t:menu />

	<div align="center">
		<!-- Add new Article buttonn -->
		<input type="button" value="Add Article" onclick="window.location.href='showFormForAdd'; return false;" /> <br>

		<!-- Add a search box -->
		<form:form action="searchArticle" method="GET">

			<input type="text" name="searchString" />

			<input type="submit" value="Search">

		</form:form>
	</div>

</header>