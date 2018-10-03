<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travellena - All Articles</title>
</head>
<body>

	<h2>Articles</h2>
	<hr>
	<hr>

	<c:forEach var="tempArticle" items="${articles}">

		<!-- create update link variable -->
		<c:url var="updateLink" value="/article/showFormForUpdate">
			<c:param name="articleId" value="${tempArticle.id}" />
			<c:param name="fromPage" value='${path}' />
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
			<a href="${openArticle}">${tempArticle.title}, ${tempArticle.eventDate}</a>
		</h3>
		<p><a href="${updateLink}">[Update]</a>
		<a href="${deleteLink}"
			onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false">[Delete]</a>
		<br>
		<br>
		published: ${tempArticle.publishDate}
		<br>
		${tempArticle.body}
		<br>
		<hr>

	</c:forEach>

</body>
</html>