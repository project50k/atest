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
				<th scope="col">NAME</th>
				<th scope="col">DESCRIPTION</th>
				<th scope="col">OPTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allSubjects}" var="subject">
				<tr>
					<td scope="row"><c:out value="${subject.id}" /></td>
					<td><c:out value="${subject.name}" /></td>
					<td><c:out value="${subject.description}" /></td>
					<td><c:choose>
							<c:when test="${del eq subject.id}">
								<form:form method="post" modelAttribute="subject">
									<%@ include file="../jspf/delete.jspf"%>
								</form:form>
							</c:when>
							<c:otherwise>
								<div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Option</button>
									<div class="dropdown-menu">
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/subject/${subject.id}/edit">Edit</a>
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/subject/${subject.id}/delete">Delete</a>
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/subject/${subject.id}/details">Details</a>
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