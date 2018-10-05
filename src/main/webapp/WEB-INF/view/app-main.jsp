<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet">

<title>Travellena</title>

</head>

<body>

	<a href="${pageContext.request.contextPath}/article/showList">[All
		articles]</a>
	<a href="${pageContext.request.contextPath}/article/showTableOfContext">[Table
		of context]</a>
	<a href="${pageContext.request.contextPath}/article/showDrafts">[Drafts]</a>
	<a href="${pageContext.request.contextPath}/article/showAbout">[About
		us]</a>
	<br>

	<!-- Add new Article buttonn -->
	<input type="button" value="Add Article"
		onclick="window.location.href='showFormForAdd'; return false;" />
	<br>

	<!-- Add a search box -->
	<form:form action="searchArticle" method="GET">

		<input type="text" name="searchString" />
		<input type="submit" value="Search">

	</form:form>

	<h2>Five last articles</h2>
	<hr>
	<hr>

	<c:forEach var="tempArticle" items="${articles}">

		<!-- create update link variable -->
		<c:url var="updateLink" value="/article/showFormForUpdate">
			<c:param name="articleId" value="${tempArticle.id}" />
		</c:url>

		<!-- create delete link variable -->
		<c:url var="deleteLink" value="/article/delete">
			<c:param name="articleId" value="${tempArticle.id}" />
		</c:url>

		<!-- create link variable to open Article -->
		<c:url var="openArticle" value="/article/showArticle">
			<c:param name="articleId" value="${tempArticle.id}"></c:param>
		</c:url>

		<h3>
			<a href="${openArticle}">${tempArticle.title}</a>
		</h3>
		<p>
			id: ${tempArticle.id} <a href="${updateLink}">[Update]</a> <a
				href="${deleteLink}"
				onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false">[Delete]</a>
			<br> publish date: ${tempArticle.publishDate} <br> is ready
			to publish: ${tempArticle.readyToPublish} <br>
			<div class="size">${tempArticle.body}</div>
		<hr>

	</c:forEach>

</body>

</html>