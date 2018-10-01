<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travellena - Drafts</title>
</head>
<body>

	<h2>Drafts</h2>
	<hr>
	<hr>

	<c:forEach var="tempDraft" items="${drafts}">
	
		${tempDraft.title}, ${tempDraft.eventDate}
		<br>
		published: ${tempDraft.publishDate}
		<br>
		is ready to publish: ${tempDraft.readyToPublish}
		<br>
		${tempDraft.body}
		<br>
		<hr>

	</c:forEach>

</body>
</html>