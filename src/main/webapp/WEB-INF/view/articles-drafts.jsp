<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">

<title>Travellena - Drafts</title>

</head>

<t:page-template>

	<jsp:body>
	
		<h2>Drafts</h2>
	<hr>
	<hr>

	<c:forEach var="tempDraft" items="${drafts}">

		<!-- create update link variable -->
		<c:url var="updateLink" value="/article/showFormForUpdate">
			<c:param name="articleId" value="${tempDraft.id}" />
		</c:url>

		<!-- create delete link variable -->
		<c:url var="deleteLink" value="/article/delete">
			<c:param name="articleId" value="${tempDraft.id}" />
		</c:url>

		<!-- create link variable to open Article -->
		<c:url var="openDraft" value="/article/showArticle">
			<c:param name="articleId" value="${tempDraft.id}"></c:param>
		</c:url>

		<h3>
			<a href="${openDraft}">${tempDraft.title}</a>
		</h3>
		<p>
			<a href="${updateLink}">[Update]</a> <a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false">[Delete]</a>
			<br><br>is ready to publish: ${tempDraft.readyToPublish}
			<br> опубликовано: <javatime:format value="${tempDraft.publishDate}" style="MS" pattern="dd MMMM yyyy, HH:mm" />
		
			<div class="trim">${tempDraft.body}</div>
		<a href="${openDraft}">[читать полностью]</a>
		<hr>

	</c:forEach>
	
	</jsp:body>

</t:page-template>

</html>