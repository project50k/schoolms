<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../jspf/headconfig.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>School manage-system</title>
</head>
<body>

	<%@ include file="../jspf/header.jspf"%>

	<c:if test="${sessionScope.user!=null}">
		<%@ include file="../jspf/main_menu.jspf"%>
	</c:if>

	<form:form method="post" modelAttribute="user" class="form-container">
	
	<div class="form-title">Email:
	<form:input path="email" class="form-field"/><form:errors path="email" class="form-field"/></div></div>
	
	<div class="form-title">Password:
	<form:password path="password" class="form-field"/><form:errors path="password" class="form-field"/></div>
	
	<div class="form-title">Personal data</div>
	
	<div class="form-title">First name:
	<form:input path="details.firstName" class="form-field"/><form:errors path="details.firstName" class="form-field"/></div>
	
	<div class="form-title">Last name:
	<form:input path="details.lastName" class="form-field"/><form:errors path="details.lastName" class="form-field"/></div>
	
	<div class="form-title">Legal Guardian data</div>
	
	<div class="form-title">First name:
	<form:input path="details.guardianFirstName" class="form-field"/><form:errors path="details.guardianFirstName" class="form-field"/></div>
	
	
	<p><input type="submit" value="Add" class="submit-button" /></p>
	
	</form:form>



	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>