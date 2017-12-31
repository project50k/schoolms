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



	<p>Student List</p>
	
	<table class="darkTable">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>E-MAIL</th>
				<th>DETAILS</th>
				<th>GROUP</th>
				<th>OPTION</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tfoot>
		<tbody>
		<c:forEach items="${allStudents}" var="stud">
		<tr>
				<td><c:out value="${stud.id}" /></td>
				<td><c:out value="${stud.username}" /></td>
				<td><c:out value="${stud.email}" /></td>
				<td>cell4_1</td>
				<td>cell5_1</td>
				<td>cell6_1</td>
			</tr>
		
		</c:forEach>
			
		</tbody>
		</tr>
	</table>

	<%@ include file="jspf/footer.jspf"%>

</body>
</html>