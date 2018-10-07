<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Travellena - ${article.id}</title>

</head>

<body>

	<t:header />

	<!-- create update link variable -->
	<c:url var="updateLink" value="/article/showFormForUpdate">
		<c:param name="articleId" value="${article.id}" />
	</c:url>

	<!-- create delete link variable -->
	<c:url var="deleteLink" value="/article/delete">
		<c:param name="articleId" value="${article.id}" />
	</c:url>

	<h2>${article.title}</h2>
	<a href="${updateLink}">[Update]</a>
	<a href="${deleteLink}"
		onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false">[Delete]</a>
	<hr>
	<p>${article.body}</p>

</body>

</html>