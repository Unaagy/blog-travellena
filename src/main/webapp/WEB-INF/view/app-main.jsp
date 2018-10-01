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
	<a href="${pageContext.request.contextPath}/article/showAbout">[About us]</a>
	<br>

	<h2>Five last articles</h2>
	<hr>
	<hr>

	<c:forEach var="tempArticle" items="${articles}">
	
		id: ${tempArticle.id} title: ${tempArticle.title}
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