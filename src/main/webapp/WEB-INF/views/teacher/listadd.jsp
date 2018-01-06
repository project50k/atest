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
	
	<table class="darkTable">
		<thead>
			<tr>
				<th>ID</th>
				<th>EMAIL</th>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>ADD Teacher</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tfoot>
		<tbody>
		<c:forEach items="${availableTeachers}" var="teacher">
			<tr>
				<td><c:out value="${teacher.id}" /></td>
				<td><c:out value="${teacher.email}" /></td>
				<td><c:out value="${teacher.firstName}" /></td>
				<td><c:out value="${teacher.lastName}" /></td>
				 <td>
				 
		  	</td>
			
		</c:forEach>
			<form:form method="post" modelAttribute="setTeacher">
			 	<form:select type="text" path="student.id">
		  		<form:options items="${allStudents}" itemValue="id" itemLabel="firstName" />
		  		</form:select>
		  		<input type="submit" value="add">
			</form:form>
			
			
		</tr>
		


			
			
			
		
		
		</tbody>
		</tr>
	</table>



	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>