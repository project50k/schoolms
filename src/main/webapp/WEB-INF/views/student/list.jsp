<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page session="true"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<p>Student List</p>
	
	<table class="darkTable">
		<thead>
			<tr>
				<th>ID</th>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>GROUP NAME</th>
				<th>DETAILS</th>
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
		<c:forEach items="${availableStudents}" var="stud">
		<tr>
				<td><c:out value="${stud.id}" /></td>
				<td><c:out value="${stud.details.firstName}" /></td>
				<td><c:out value="${stud.details.lastName}" /></td>
				<td>
				<c:forEach items="${stud.schoolgroups}" var="group">
					<c:out value="${group.groupname}" />
				</c:forEach>
				</td>
				<td><c:out value="DETAILS" /></td>
				<td>
				
				<c:choose>
					  <c:when test="${delUser eq stud.id}">
					   		<c:out value="Do you really want to delete?" />
					   		<a href="${pageContext.request.contextPath}/student/${stud.id}/delReject">NO</a> / 
							<a href="${pageContext.request.contextPath}/student/${stud.id}/delConfirm">YES</a>
					  </c:when>
					  <c:otherwise>
					  		<a href="${pageContext.request.contextPath}/student/${stud.id}/edit">Edit</a> / 
							<a href="${pageContext.request.contextPath}/student/${stud.id}/delete">Delete</a>
					  </c:otherwise>
				</c:choose>
				
				</td>
			</tr>
		</c:forEach>
		</tbody>
		</tr>
	</table>

	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>