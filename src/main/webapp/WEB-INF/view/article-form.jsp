<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<script
	src='${pageContext.request.contextPath}/resources/editor/tinymce/js/tinymce/tinymce.min.js'></script>
<script>
	tinymce
			.init({
				// General options
				selector : '#TextEditor',
				theme : "modern",
				language : "ru",
				plugins : "advlist,anchor,autolink,autoresize,autosave,charmap,code,codesample,colorpicker,contextmenu,directionality,emoticons,fullpage,fullscreen,help,hr,image,imagetools,importcss,insertdatetime,legacyoutput,link,lists,media,nonbreaking,noneditable,pagebreak,paste,preview,print,save,searchreplace,tabfocus,table,template,textcolor,textpattern,toc,visualblocks,visualchars,wordcount",
				
				skin : "lightgray"
			});
</script>

<title>Travellena - Article Form</title>

</head>

<body>

	<h3>Article Form</h3>

	<form:form action="saveArticle" modelAttribute="article" method="POST">

		<form:hidden path="id" />
		<form:hidden path="publishDate" />
		<input type="hidden" name="fromPage" value='${fromPage}' />
		
		Title:<br>
		<form:input path="title" />
		<br>
		
		Cover image link:<br>
		<form:input path="coverLink" value="http://" />
		<br>
		
		Article content:<br>
		<form:textarea path="body" id="TextEditor" />
		<br>

		Ready to be published?: <form:checkbox path="readyToPublish" />
		<br>
		
		"About" article: <form:checkbox path="info" />
		<br>

		<input type="submit" value="Save Article">

	</form:form>

	<br>
	<input type="button" value="<<--- Назад" onclick="history.go(-1)" />

</body>

</html>