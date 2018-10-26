<%@tag description="Menu page block" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark shadow p-3 mb-5">

	<div class="container font-weight-bold">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">Travellena</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto text-uppercase">
			
				<security:authorize access="hasRole('ADMIN')">
					<li class="nav-item text-lowercase">
						<span class="navbar-brand">
							<!-- Add new Article buttonn -->
							<input class="btn btn-outline-success my-2 my-sm-0" type="button" value="Новая" onclick="window.location.href='showFormForAdd'; return false;" />
						</span>
					</li>
					<li class="nav-item text-lowercase">
						<form:form class="form-inline" action="${pageContext.request.contextPath}/logout" method="POST">
							<span class="navbar-brand mb-0 h6">
								<security:authentication property="principal.username" />: 
								<security:authentication property="principal.authorities" />
								<input class="btn btn-outline-warning my-2 my-sm-0" type="submit" value="Выйти">
							</span>
						</form:form>
					</li>
				</security:authorize>
				
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">Главная</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/article/showList">Все статьи</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/article/showTableOfContext">Содержание</a></li>
				<security:authorize access="hasRole('ADMIN')">
					<li class="nav-item"><a class="nav-link text-warning" href="${pageContext.request.contextPath}/article/showDrafts">Черновики</a></li>
				</security:authorize>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/article/showAbout">Информация</a></li>
			</ul>
		</div>
		
	</div>

</nav>