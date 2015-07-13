
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actor Edit Form</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">Update Form</div>



		<c:url var="userRegistration" value="saveUser.html" />
		<form:form id="updateForm" modelAttribute="actor" method="post"
			action="editActor.html">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="id">id</form:label></td>
					<td><form:input path="id" value="${actor.id}" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" value="${actor.firstName}" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" value="${actor.lastName}" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Update" /></td>
				</tr>
			</table>
		</form:form>


		<a href="listActors.html">Click Here to see User List</a>
	</center>
</body>
</html>

