<%@tag description="Header page block with Add button and Search" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<header>

	<!-- Show menu block -->
	<t:menu />

	<!-- Main Logo with search -->
	<div class="card bg-dark text-white border-0 card text-center mx-auto">
		<img class="card-img rounded-0" src="${pageContext.request.contextPath}/resources/img/header-img.jpeg" alt="Card image">
		<div class="card-img-overlay h-100 d-flex flex-column justify-content-center text-black-50">
			<h1 class="card-title display-2 font-weight-bold">Hello, Asia!</h1>
			<p class="card-text font-weight-bold">downshifting</p>
		</div>
		<div class="card-img-overlay h-80 d-flex flex-column justify-content-end">
			<!-- Add a search box -->
			<form:form action="searchArticle" method="GET">
				<input class="form-control-sm" type="text" name="searchString" />
				<input class="btn btn-success btn-sm" type="submit" value="Поиск по слову">
			</form:form>
		</div>
	</div>

</header>