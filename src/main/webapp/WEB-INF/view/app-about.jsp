<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travellena - About</title>
</head>

<t:page-template>

	<jsp:body>
	
		<!-- create update link variable -->
	<c:url var="updateLink" value="/article/showFormForUpdate">
		<c:param name="articleId" value="${infoArticle.id}" />
	</c:url>

	<h2>${infoArticle.title}</h2>
	<hr>
	<a href="${updateLink}">[Update]</a>
	<br> ${infoArticle.body}
	
	</jsp:body>

</t:page-template>

</html>