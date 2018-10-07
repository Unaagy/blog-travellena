<%@tag description="Menu page block"
	pageEncoding="UTF-8"%>

<nav>
	<a href="${pageContext.request.contextPath}/">[Home]</a> 
	<a href="${pageContext.request.contextPath}/article/showList">[All articles]</a> 
	<a href="${pageContext.request.contextPath}/article/showTableOfContext">[Table of context]</a> 
	<a href="${pageContext.request.contextPath}/article/showDrafts">[Drafts]</a> 
	<a href="${pageContext.request.contextPath}/article/showAbout">[About us]</a>
</nav>