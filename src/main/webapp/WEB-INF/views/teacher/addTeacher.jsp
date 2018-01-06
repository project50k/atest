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

	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<form:form method="post" modelAttribute="teacher">

			<h4>Add new teacher</h4>
			Email: <form:input path="email" /><form:errors path="email" />
			Password: <form:password path="password" /><form:errors path="password" />
			First name: <form:input path="firstName" /><form:errors path="firstName" />
			Last name: <form:input path="lastName" /><form:errors path="lastName" />

		<input type="submit" value="Add" class="btn btn-primary">
	
	</form:form>

  	</nav>
  
  
  
	<%@ include file="../jspf/footer.jspf"%>

</body>
</html>