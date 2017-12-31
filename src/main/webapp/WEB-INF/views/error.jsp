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

	
	<h1>ERROR PAGE<h1>
	<h1>ERROR PAGE<h1>
	<h1>ERROR PAGE<h1>
	
	
	

	<%@ include file="jspf/footer.jspf"%>

</body>
</html>