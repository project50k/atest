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
	<%@ include file="../jspf/main_menu.jspf"%>

	<div >
	<h4>List of all students</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">EMAIL</th>
				<th scope="col">FIRST NAME</th>
				<th scope="col">LAST NAME</th>
				<th scope="col">OPTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allStudents}" var="student">
				<tr>
					<td scope="row"><c:out value="${student.id}" /></td>
					<td><c:out value="${student.email}" /></td>
					<td><c:out value="${student.firstName}" /></td>
					<td><c:out value="${student.lastName}" /></td>
					<td><c:choose>
							<c:when test="${del eq student.id}">
								<form:form method="post" modelAttribute="student">
									<c:out value="Confirm delete" />
									</br>
									<input type="submit" value="Yes" class="btn btn-success">
									<input action="action"
										onclick="window.history.go(-1); return false;" type="button"
										class="btn btn-danger" value="No" />
								</form:form>
							</c:when>
							<c:otherwise>
								<div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Option</button>
									<div class="dropdown-menu">
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/student/${student.id}/edit">Edit</a>
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/student/${student.id}/delete">Delete</a>
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/student/${student.id}/details">Details</a>
									</div>
								</div>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>


	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>