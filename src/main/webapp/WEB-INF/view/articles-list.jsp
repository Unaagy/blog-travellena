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
	
		${tempArticle.title}, ${tempArticle.eventDate}
		<br>
		published: ${tempArticle.publishDate}
		<br>
		${tempArticle.body}
		<br>
		<hr>

	</c:forEach>

</body>
</html>