<%@tag description="Menu page block" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
	
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
	<div class="container font-weight-bold">
				 <a class="navbar-brand" href="${pageContext.request.contextPath}/">Travellena</a>
			
			 	<ul class="navbar-nav ml-auto text-uppercase">
				 	<li class="nav-item">
					 	<a class="nav-link" href="${pageContext.request.contextPath}/">Главная</a>
					</li>
					<li class="nav-item"> 	 
						<a class="nav-link" href="${pageContext.request.contextPath}/article/showList">Все статьи</a>
					</li>
					<li class="nav-item">	 
						<a class="nav-link" href="${pageContext.request.contextPath}/article/showTableOfContext">Содержание</a>
					</li>	 
					<security:authorize access="hasRole('ADMIN')">
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/article/showDrafts">Черновики</a>
						</li>	
					</security:authorize>
					<li class="nav-item"> 
						<a class="nav-link" href="${pageContext.request.contextPath}/article/showAbout">Информация</a>
					</li>
				</ul>
	</div>
</nav>
	




