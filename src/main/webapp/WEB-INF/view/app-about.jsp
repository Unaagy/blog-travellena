<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travellena - About</title>
</head>
<body>

	<!-- create update link variable -->
	<c:url var="updateLink" value="/article/showFormForUpdate">
		<c:param name="articleId" value="${infoArticle.id}" />
		<c:param name="fromPage" value='${path}' />
	</c:url>

	<h2>${infoArticle.title}</h2>
	<hr>
	<a href="${updateLink}">[Update]</a>
	<br> ${infoArticle.body}

</body>
</html>