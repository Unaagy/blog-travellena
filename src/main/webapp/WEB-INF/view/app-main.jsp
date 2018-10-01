<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<input type="button" value="Add Article"
		onclick="window.location.href='showFormForAdd'; return false;" />
	<br>

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
	
		id: ${tempArticle.id} title: ${tempArticle.title}
		<a href="${updateLink}">[Update]</a>
		<a href="${deleteLink}"
			onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false">[Delete]</a>
		<br>
		publish date: ${tempArticle.publishDate}
		<br>
		is ready to publish: ${tempArticle.readyToPublish}
		<br>
		${tempArticle.body}
		<hr>

	</c:forEach>

</body>
</html>