<%@tag description="Menu page block" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav align="center">
	<a href="${pageContext.request.contextPath}/">[Главная]</a> 
	<a href="${pageContext.request.contextPath}/article/showList">[Все статьи]</a> 
	<a href="${pageContext.request.contextPath}/article/showTableOfContext">[Содержание]</a> 
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/article/showDrafts">[Черновики]</a>
	</security:authorize> 
	<a href="${pageContext.request.contextPath}/article/showAbout">[Информация]</a>
</nav>