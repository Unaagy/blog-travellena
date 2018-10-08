<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Travellena - ${article.title}</title>

</head>

<t:page-template>
	<jsp:body>

		<h2>${article.title}</h2>
		
		<!--  Security content -->
		<security:authorize access="hasRole('ADMIN')">
		
			<!-- create update link variable -->
			<c:url var="updateLink" value="/article/showFormForUpdate">
				<c:param name="articleId" value="${article.id}" />
			</c:url>
	
			<!-- create delete link variable -->
			<c:url var="deleteLink" value="/article/delete">
				<c:param name="articleId" value="${article.id}" />
			</c:url>
			
			<a href="${updateLink}">[Update]</a>
			<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false">[Delete]</a>
		</security:authorize>
		
		<hr>
		<p>${article.body}</p>
			
	</jsp:body>
</t:page-template>

</html>