<%@tag description="Header page block with Add button and Search" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<header>

	<!-- Show menu block -->
	<t:menu />

	<!-- Main Logo with search -->
	<div class="container-fluid bg-dark text-black-50 text-center"
		style="background-image: url('${pageContext.request.contextPath}/resources/img/header-img.jpeg'); height: 666px; background-size: cover; background-attachment: scroll; position: relative; background-position: center center;">
		<div class="row">
			<div class="card-img-overlay d-flex flex-column justify-content-center text-black-50">
				<h1 class="card-title display-2 font-weight-bold">Hello, Asia!</h1>
				<p class="card-text font-weight-bold h3">downshifting</p>
			</div>
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