<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="jspf/headconfig.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>School manage-system</title>
</head>
<body>

	<%@ include file="jspf/header.jspf"%>

	<c:if test="${sessionScope.user!=null}">
		<%@ include file="jspf/main_menu.jspf"%>
	</c:if>

	<p>Student Add</p>
	
	<form:form method="post" modelAttribute="student">
	<p>Username <form:input path="username"/><form:errors path="username"/></p>
	<p>Email <form:input path="email"/><form:errors path="email"/></p>
	<p>Password <form:password path="password"/><form:errors path="password"/></p>
	<p><input type="submit"/></p>
	</form:form>

	<%@ include file="jspf/footer.jspf"%>

</body>
</html>