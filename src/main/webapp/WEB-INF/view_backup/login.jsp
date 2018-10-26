<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Tabs template connection -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travellena - Login</title>
</head>
<body>

	<t:menu />

	<div align="center">
		<h3>Logint to Travallena blog</h3>

		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

			<c:if test="${param.error != null}">
				<b><i>*** Sorry! You entered invalid username/password ***</i></b>
			</c:if>

			<c:if test="${param.logout != null}">
				<b><i>*** You have been logged out ***</i></b>
			</c:if>

			<p>
				User name: <input type="text" name="username">
			</p>
			<p>
				Password: <input type="password" name="password">
			</p>
			<p>
				<input type="submit" value="Login">
			</p>

		</form:form>
	</div>

</body>
</html>