<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travellena - Article Form</title>
</head>
<body>

	<h3>Article Form</h3>

	<form:form action="saveArticle" modelAttribute="article" method="POST">

		<form:hidden path="id" />
		<form:hidden path="publishDate" />
		<form:hidden path="author" />
		
		Title:<br>
		<form:input path="title" accept-charset="UTF-8"/>
		<br>
		
		Event date:<br>
		<form:input type="date" path="eventDate" />
		<br>
		
		Cover image link:<br>
		<form:input path="coverLink" value="http://" />
		<br>
		
		Article content:<br>
		<form:textarea path="body" />
		<br>

		Ready to be published?: <form:checkbox path="readyToPublish" />
		<br>
		
		"About" article: <form:checkbox path="info" />
		<br>

		<input type="submit" value="Save Article">

	</form:form>

	<a href="${pageContext.request.contextPath}/article/main">Back to
		Main page</a>

</body>
</html>