<%@tag description="Tima displaying template" pageEncoding="UTF-8"%>

<%@tag import="java.time.LocalDateTime" %>
<%@ attribute name="timeTag" required="true" type="java.time.LocalDateTime"%>

<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime"%>

<javatime:format value="${timeTag}" style="MS" pattern="dd MMMM yyyy, HH:mm" />
