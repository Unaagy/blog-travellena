<%@tag description="Menu page block" pageEncoding="UTF-8"%>
	
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav align="center">
	<a href="${pageContext.request.contextPath}/">[Home]</a> 
	<a href="${pageContext.request.contextPath}/article/showList">[All articles]</a> 
	<a href="${pageContext.request.contextPath}/article/showTableOfContext">[Table of context]</a> 
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/article/showDrafts">[Drafts]</a>
	</security:authorize> 
	<a href="${pageContext.request.contextPath}/article/showAbout">[About us]</a>
</nav>