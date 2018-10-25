	<%@tag description="Menu page block" pageEncoding="UTF-8"%>

	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/">Главная</a></li> 
			<li><a href="${pageContext.request.contextPath}/article/showList">Все статьи</a></li> 
			<li><a href="${pageContext.request.contextPath}/article/showTableOfContext">Содержание</a></li> 
			<security:authorize access="hasRole('ADMIN')">
				<li><a href="${pageContext.request.contextPath}/article/showDrafts">Черновики</a></li>
			</security:authorize> 
			<li><a href="${pageContext.request.contextPath}/article/showAbout">Информация</a></li>
		</ul>
	</nav>